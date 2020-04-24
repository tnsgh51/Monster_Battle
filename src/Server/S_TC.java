package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import Send.TC_Object;
import Send.TC_People;

public class S_TC extends Thread {
	private Socket withClient = null;
	private Socket withClient2 = null;
	private Socket withClient3 = null;
	
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;

	private InputStream reMsg2= null;
	private OutputStream sendMsg2 = null;
	
	private InputStream reMsg3= null;
	private OutputStream sendMsg3 = null;
	
	
	private ObjectOutputStream sendObject = null;
	private ObjectInputStream reObject = null;
	
	private ObjectOutputStream sendObject3 = null;
	private ObjectInputStream reObject3 = null;
	private S_Analysis s = null;
	private ServerSocket serverS2 = null;
	private ServerSocket serverS3 = null;
	
	S_TC(Socket c, ServerSocket serverS2,int port, ServerSocket serverS3, int port3) {
		this.serverS2 = serverS2;
		this.serverS3 = serverS3;
		
		s = S_Analysis.getInstance();
		
		withClient = c;
		
		try {
			reMsg = withClient.getInputStream();
			sendMsg = withClient.getOutputStream();
			
			socket2();
			socket3();
			
			
			send(Integer.toString(port));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private void socket3() {
		new Thread(new Runnable() {
		@Override
		public void run() {
			try {
				withClient3 = serverS3.accept();
				reMsg3 = withClient3.getInputStream();
				sendMsg3 = withClient3.getOutputStream();
				sendObject3 = new ObjectOutputStream(sendMsg3);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}).start();
	}


	private void socket2() {
		new Thread(new Runnable() {
		@Override
		public void run() {
			try {
			withClient2 = serverS2.accept();
				reMsg2 = withClient2.getInputStream();
			sendMsg2 = withClient2.getOutputStream();
			sendObject = new ObjectOutputStream(sendMsg2);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}).start();
	}


	public void run() {
//		receive2();
		receive();
	}
	
	public void sendO(TC_Object tc_Object) {
		try {
			
			sendObject.writeObject(tc_Object);
			sendObject.flush();
			sendObject.reset();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void sendP(TC_People tp) {
		try {
			
			sendObject3.writeObject(tp);
			sendObject3.flush();
			sendObject3.reset();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	private void receiveO() {
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					while (true) {
//						reObject = new ObjectInputStream(reMsg2);
//						BattleRoom k =(BattleRoom)reObject.readObject();
//					}
//				} catch (Exception e) {
//					return;
//				}
//			}
//		}).start();
//	}


	private void receive() {
		while (true) {
			try {
				byte[] reBuffer = new byte[1024];
				reMsg.read(reBuffer);
				String msg = new String(reBuffer);
				msg = msg.trim();
				s.check(msg,this);
			} catch (Exception e) {
				s.logout(this);
				break;
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
