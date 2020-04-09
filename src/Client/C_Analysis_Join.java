package Client;

public class C_Analysis_Join {
	private Frame_admin fa = Frame_admin.getInstance();
	public void check(String msg) {
		String w = msg.substring(0,msg.indexOf(" "));
		String k = msg.substring(msg.indexOf(" ")+1,msg.length());
		switch(w){
		case "idcheck":
			idid(k);
			break;
		case "apply":
			tjdrhd();
			break;
		}
	}
	private void tjdrhd() {
		fa.applySuccess();
	}
	public void idid(String msg) {
		String w = msg.substring(0,msg.indexOf(" "));
		String k = msg.substring(msg.indexOf(" ")+1,msg.length());
		switch(w){
		case "fail":
			fa.idfail(k);
			break;
		case "success":
			System.out.println("1번");
			fa.idsuccess();
			break;
		}
	}

}
