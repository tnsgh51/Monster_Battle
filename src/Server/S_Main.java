package Server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class S_Main {
	public static ArrayList<S_TC> getTcAll() {
		return tcAll;
	}

	private static ArrayList<S_TC> tcAll = new ArrayList<S_TC>();

	public static void main(String[] args) throws IOException {

		new S_Main();

	}

	private S_Main() throws IOException {
		ServerSocket serverS = null;
		Socket withClient = null;
		ServerSocket serverS2 = null;
		ServerSocket serverS3 = null;
		serverS = new ServerSocket();
		serverS.bind(new InetSocketAddress("10.0.0.108", 9999));

		serverS2 = new ServerSocket();
		serverS3 = new ServerSocket();

		Random r = new Random();
		int port = r.nextInt(997) + 9000;

		int port3 = port + 1;

		serverS2.bind(new InetSocketAddress("10.0.0.108", port));
		serverS3.bind(new InetSocketAddress("10.0.0.108", port3));

		while (true) {
			System.out.println("서버 준비완료");

			withClient = serverS.accept();

			S_TC sss = new S_TC(withClient, serverS2, port, serverS3, port3);
			tcAll.add(sss);

			sss.start();
		}
	}

}
