package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class C_TC {
	private Socket withServer = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	
	public C_TC(Socket withServer) {
		this.withServer = withServer;
		try {
			reMsg = withServer.getInputStream();
			sendMsg = withServer.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
					}
				} catch (Exception e) {
					return;
				}
			}
		}).start();

	}

	public void send(String reMsg) {

		try {
			sendMsg.write(reMsg.getBytes());
		} catch (Exception e) {
			System.out.println("send end");
			return;
		}
	}
}
