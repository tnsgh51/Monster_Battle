package Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Server.S_Analysis;

public class testS_TC extends Thread {
	private Socket withClient = null;
	private Socket withClient2 = null;
	
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;

	private InputStream reMsg2= null;
	private OutputStream sendMsg2 = null;
	
	private ObjectOutputStream sendObject = null;
	private ObjectInputStream reObject = null;
	testS_TC(Socket c, ServerSocket serverS2,int port) throws IOException {
		withClient = c;
		
		
		reMsg = withClient.getInputStream();
		sendMsg = withClient.getOutputStream();
		send(Integer.toString(port));
		
		withClient2 = serverS2.accept();
		try {
			
			reMsg2 = withClient2.getInputStream();
			sendMsg2 = withClient2.getOutputStream();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void run() {
		receive2();
		receive();
	}
	private void receive2() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						reObject = new ObjectInputStream(reMsg2);
						SomeThing k =(SomeThing)reObject.readObject();
						System.out.println(k.in);
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
				System.out.println(msg);
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