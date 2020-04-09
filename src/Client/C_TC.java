package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class C_TC {
	private Socket withServer = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	private C_Analysis ca = C_Analysis.getInstance();
	private Frame_admin fa = Frame_admin.getInstance();
	private ObjectOutputStream sendObject = null;
	public C_TC(Socket withServer) {
		this.withServer = withServer;
		try {
			reMsg = withServer.getInputStream();
			sendMsg = withServer.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Frame_Login login=new Frame_Login(this);
		fa.setFL(login);
		ca.setFa();
		fa.setCTC(this);
		
		receive();
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
