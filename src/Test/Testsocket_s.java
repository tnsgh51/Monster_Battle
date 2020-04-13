package Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Testsocket_s {

	public static void main(String[] args) throws IOException {
	
		new Testsocket_s();

	}

	private Testsocket_s() throws IOException {
		ServerSocket serverS = null;
		ServerSocket serverS2 = null;
		Socket withClient = null;
		Socket withClient2 = null;

		serverS = new ServerSocket();
		serverS.bind(new InetSocketAddress("10.0.0.108", 9999));
		
		serverS2 = new ServerSocket();
		Random r = new Random();
		int port = r.nextInt(998)+9000;
		serverS2.bind(new InetSocketAddress("10.0.0.108", port));

		while (true) {
			System.out.println("서버 준비완료");
			
			withClient = serverS.accept();

			testS_TC sss = new testS_TC(withClient,serverS2,port);
			sss.start();
		}
	}
	
}

