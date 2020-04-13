package Client;

import java.io.IOException;
import java.net.Socket;

public class C_Main {
	public static void main(String[] args) {
		new C_Main();
	}
	
	
	private C_Main(){
		Socket withServer = null;
		Socket withServer2 = null;
		
		try {
			withServer = new Socket("10.0.0.108",9999);
			Thread.sleep(1000);
			new C_TC(withServer,withServer2);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
