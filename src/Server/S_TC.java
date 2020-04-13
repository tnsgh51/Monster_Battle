package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Test.SomeThing;

public class S_TC extends Thread {
	private Socket withClient = null;
	private Socket withClient2 = null;
	
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;

	private InputStream reMsg2= null;
	private OutputStream sendMsg2 = null;
	
	private ObjectOutputStream sendObject = null;
	private ObjectInputStream reObject = null;
	private S_Analysis s = null;

	S_TC(Socket c, ServerSocket serverS2,int port) {
		s = S_Analysis.getInstance();
		withClient = c;
		try {
			reMsg = withClient.getInputStream();
			sendMsg = withClient.getOutputStream();
			send(Integer.toString(port));
			
			withClient2 = serverS2.accept();
			reMsg2 = withClient2.getInputStream();
			sendMsg2 = withClient2.getOutputStream();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void run() {
//		receive2();
		receive();
	}
	
	public void sendO() {
		try {
			sendObject = new ObjectOutputStream(sendMsg2);
//			sendObject.writeObject((Object) ww);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void receive2() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						reObject = new ObjectInputStream(reMsg2);
						SomeThing k =(SomeThing)reObject.readObject();
						System.out.println("??");
					}
				} catch (Exception e) {
					return;
				}
			}
		}).start();
	}


	private void receive() {
		while (true) {
			try {
				byte[] reBuffer = new byte[100];
				reMsg.read(reBuffer);
				String msg = new String(reBuffer);
				msg = msg.trim();
				s.check(msg,this);
			} catch (Exception e) {

			}
		}
	}

	public void send(String msg) {
		try {
			sendMsg.write(msg.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
