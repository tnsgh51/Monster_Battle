package Client;

public class C_Analysis {
	private Frame_admin fa = null;
	private static C_Analysis c = null;
	private C_Analysis_Login cal = null;
	private C_Analysis_Battle cab = null;
	private C_Analysis_Room car = null;
	private C_Analysis_Join caj = null;
	
	public static C_Analysis getInstance() {
		if(c== null) {
			c = new C_Analysis();
		}
		return c;
	}
	
	private C_Analysis() {
		setting();
		setFa();
	}
	private void setting() {	
		cal = new C_Analysis_Login();
		cab = new C_Analysis_Battle();
		car = new C_Analysis_Room();
		caj = new C_Analysis_Join();
		System.out.println("분석 준비 완료");
	}
	public void msgA(String msg) {
		String w = msg.substring(0,msg.indexOf(" "));
		String k = msg.substring(msg.indexOf(" ")+1,msg.length());
		switch(w){
		case "/login":
			cal.check(k);
			break;
		case "/room":
			car.check(k);
			break;
		case "/battle":
			cab.check(k);
			break;
		case "/join":
			caj.check(k);
			break;
		}
	}

	public void setFa() {
		this.fa= Frame_admin.getInstance();
	}

}
