package Server;

import java.util.ArrayList;

public class DTO_Member {
	
	public ArrayList<DTO_BattleList> getMybattleList() {
		return mybattleList;
	}
	public void addMyList(DTO_BattleList b) {
		mybattleList.add(b);
	}
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
	
	private ArrayList<DTO_BattleList> mybattleList = new ArrayList<DTO_BattleList>();
	
	public boolean checkIdPwd(String id, String pwd) {
		if(this.id.equals(id)&&this.password.equals(pwd)) {
			return true;
		}
		return false;
	}
	
}
