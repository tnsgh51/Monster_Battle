package Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class testC_TC {
	private Socket withServer = null;
	private Socket withServer2 = null;

	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	private InputStream reMsg2 = null;
	private OutputStream sendMsg2 = null;

	private ObjectOutputStream sendObject = null;
	private ObjectInputStream reObject = null;
	Scanner in = new Scanner(System.in);

	public testC_TC(Socket withServer, Socket withServer2) {
		this.withServer = withServer;
		try {
			reMsg = this.withServer.getInputStream();
			sendMsg = this.withServer.getOutputStream();

			withServer2 = new Socket("10.0.0.108", receivePort());
			this.withServer2 = withServer2;
			System.out.println("1");
			reMsg2 = this.withServer2.getInputStream();
			sendMsg2 = this.withServer2.getOutputStream();

		} catch (IOException e) {
			e.printStackTrace();
		}
		receive();
		
		receive2();
		
		in();
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

	private void in() {
		System.out.println("입력");
		while (true) {
			String k = in.nextLine();
			switch (k) {
			case "1":
				System.out.println(321321);
				send(k);
				break;
			case "2":
				sendO(k);
			}
		}
	}

	public void sendO(String k) {
		SomeThing ww = new SomeThing("dd");
		try {

			sendObject = new ObjectOutputStream(sendMsg2);
			sendObject.writeObject((Object) ww);

		} catch (IOException e) {
			// TODO Auto-generated catch block
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
						byte[] reBuffer = new byte[100];
						reMsg.read(reBuffer);
					}
				} catch (Exception e) {
					return;
				}
			}
		}).start();
	}

	private void receive() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("???");
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
			Thread.sleep(1);
			sendMsg.write(reMsg.getBytes());
		} catch (Exception e) {
			return;
		}
	}
}
