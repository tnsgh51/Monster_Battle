package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class S_TC extends Thread {
	private Socket withClient = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	private S_Analysis s = null;

	S_TC(Socket c) {
		s = S_Analysis.getInstance();
		withClient = c;
		try {
			reMsg = withClient.getInputStream();
			sendMsg = withClient.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void run() {
		receive();
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
