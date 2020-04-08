package Client;

public class C_Analysis_Login {
	private Frame_admin fa = Frame_admin.getInstance();
	public void check(String k) {
		if(k.equals("success")) {
			fa.Frame_RoomStart();
		}
		else {
			fa.loginFalse();
		}
	}

}
