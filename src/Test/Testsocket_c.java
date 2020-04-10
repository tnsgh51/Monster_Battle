package Test;

import java.io.IOException;
import java.net.Socket;

public class Testsocket_c {
	public static void main(String[] args) {
		new Testsocket_c();
	}
	
	
	private Testsocket_c(){
		Socket withServer = null;
		Socket withServer2 = null;
		
		try {
			withServer = new Socket("10.0.0.108",9999);
			Thread.sleep(1000);
			System.out.println("ddd");
			withServer2 = new Socket("10.0.0.108",9998);
			System.out.println("rrr");
			new testC_TC(withServer,withServer2);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}

