package Client;

public class C_Analysis_Room {
	private Frame_admin fa = Frame_admin.getInstance();
	public void check(String msg) {
		String w = msg.substring(0, msg.indexOf(" "));
		String k = msg.substring(msg.indexOf(" ") + 1, msg.length());
		switch (w) {
		case "delete":	
			fa.deleteFriend(k);
			break;
		case "add":	
			fa.addFriend(k);
			break;
		case "msg":
			fa.addMsg(k);
			break;
		case "battle":
			rbcheck(k);
			break;
		}
	}
	private void rbcheck(String msg) {
		String w = msg.substring(0, msg.indexOf(" "));
		String k = msg.substring(msg.indexOf(" ") + 1, msg.length());
		switch (w) {
		case "apply":
			fa.battleapply(k);
			break;
		}		
	}

}
