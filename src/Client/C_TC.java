package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import Send.TC_Object;
import Send.TC_People;

public class C_TC {
	private Socket withServer = null;
	private Socket withServer2 = null;
	private Socket withServer3 = null;

	private InputStream reMsg = null;
	private OutputStream sendMsg = null;

	private InputStream reMsg2 = null;

	private InputStream reMsg3 = null;

	private ObjectInputStream reObject = null;
	
	private ObjectInputStream reObject3 = null;
	
	private C_Analysis ca = C_Analysis.getInstance();
	private Frame_admin fa = Frame_admin.getInstance();
	public C_TC(Socket withServer) {
		this.withServer = withServer;
		try {
			reMsg = this.withServer.getInputStream();
			sendMsg = this.withServer.getOutputStream();
			int t=receivePort();
			withServer2 = new Socket("10.0.0.108", t);
			withServer3 = new Socket("10.0.0.108", t+1);
			
			reMsg2 = this.withServer2.getInputStream();
			reObject = new ObjectInputStream(reMsg2);
			
			reMsg3 = this.withServer3.getInputStream();
			reObject3 = new ObjectInputStream(reMsg3);

		} catch (IOException e) {
			e.printStackTrace();
		}
		Frame_Login login=new Frame_Login(this);
		fa.setFL(login);
		ca.setFa();
		fa.setCTC(this);
		
		receive();
		receiveO();
		receiveP();
	}
	
	private void receiveO() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						Object o =reObject.readObject();
						TC_Object k =(TC_Object)o;
						ca.msgA(k);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();		
	}
	private void receiveP() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					while (true) {
						Object o =reObject3.readObject();
						TC_People p =(TC_People)o;
						ca.msgA(p);
					}
				} catch (Exception e) {
					e.printStackTrace();
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
						byte[] reBuffer = new byte[1024];
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
