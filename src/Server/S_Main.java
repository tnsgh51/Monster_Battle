package Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class S_Main {
	public static void main(String[] args) throws IOException {

		new S_Main();

	}

	private S_Main() throws IOException {
		ServerSocket serverS = null;
		Socket withClient = null;

		serverS = new ServerSocket();
		serverS.bind(new InetSocketAddress("10.0.0.108", 9999));

		while (true) {
			System.out.println("서버 준비완료");
			withClient = serverS.accept();

			S_TC sss = new S_TC(withClient);
			sss.start();
		}
	}
}
