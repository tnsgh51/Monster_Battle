package Client;

public class C_Analysis_Login {
	private Frame_admin fa = Frame_admin.getInstance();
	public void check(String k) {
		if(k.equals("success")) {
			fa.Frame_RoomStart();
		}
		else if(k.equals("false")){
			fa.loginFalse("id와 비밀번호를 체크해주세요");
		}else if(k.equals("already")) {
			fa.loginFalse("이미 접속한 아이디 입니다.");
		}
	}

}
