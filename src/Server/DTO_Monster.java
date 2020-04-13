package Server;

public class DTO_Monster {
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public float getLv() {
		return lv;
	}
	
	public void setLv(float lv) {
		this.lv = lv;
	}
	
	private String id;
	private String origin;
	private String nickname;
	private float lv=1;
	
}
