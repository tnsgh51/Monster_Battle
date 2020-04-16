package Server;

import Monster.Monster;

public class DTO_Member {
	public S_TC getS_tc() {
		return s_tc;
	}
	public void setS_tc(S_TC s_tc) {
		this.s_tc = s_tc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	private String id = "";
	private String password = "";
	private String nickname = "";
	private S_TC s_tc = null;
	private DTO_Monster [] M = new DTO_Monster[3];
	
	public boolean checkIdPwd(String id, String pwd) {
		if(this.id.equals(id)&&this.password.equals(pwd)) {
			return true;
		}
		return false;
	}
	
}
