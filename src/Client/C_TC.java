package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import Test.SomeThing;

public class C_TC {
	private Socket withServer = null;
	private Socket withServer2 = null;

	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	private InputStream reMsg2 = null;
	private OutputStream sendMsg2 = null;

	private ObjectOutputStream sendObject = null;
	private ObjectInputStream reObject = null;
	
	private C_Analysis ca = C_Analysis.getInstance();
	private Frame_admin fa = Frame_admin.getInstance();
	public C_TC(Socket withServer, Socket withServer2) {
		this.withServer = withServer;
		try {
			reMsg = this.withServer.getInputStream();
			sendMsg = this.withServer.getOutputStream();
			
			withServer2 = new Socket("10.0.0.108", receivePort());
			this.withServer2 = withServer2;
			reMsg2 = this.withServer2.getInputStream();
			sendMsg2 = this.withServer2.getOutputStream();

		} catch (IOException e) {
			e.printStackTrace();
		}
		Frame_Login login=new Frame_Login(this);
		fa.setFL(login);
		ca.setFa();
		fa.setCTC(this);
		
		receive();
		receiveO();
	}
	
	public void sendO() {
		try {
			sendObject = new ObjectOutputStream(sendMsg2);
//			sendObject.writeObject((Object) ww);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void receiveO() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						reObject = new ObjectInputStream(reMsg2);
						byte[] reBuffer = new byte[100];
						reMsg.read(reBuffer);
					}
				} catch (Exception e) {
					return;
				}
			}
		}).start();		
	}

	private int receivePort() {
		String msg = null;
		try {
			byte[] reBuffer = new byte[100];
			reMsg.read(reBuffer);
			msg = new String(reBuffer);
			msg = msg.trim();
			
		} catch (Exception e) {
		}
		return Integer.parseInt(msg);
	}

	private void receive() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						byte[] reBuffer = new byte[100];
						reMsg.read(reBuffer);
						String msg = new String(reBuffer);
						msg = msg.trim();
						System.out.println(msg);
						ca.msgA(msg);
					}
				} catch (Exception e) {
					return;
				}
			}
		}).start();

	}

	public void send(String reMsg) {
		
		try {
			Thread.sleep(1);
			sendMsg.write(reMsg.getBytes());
		} catch (Exception e) {
			return;
		}
	}
}
