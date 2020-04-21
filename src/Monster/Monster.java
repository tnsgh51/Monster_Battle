package Monster;

public class Monster {
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String[][] getSkill() {
		return skill;
	}
	public void setSkill(String[][] skill) {
		this.skill = skill;
	}
	public int getShield() {
		return shield;
	}
	public void setShield(int shield) {
		this.shield = shield;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Monster(){	
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAd() {
		return ad;
	}
	public void setAd(int ad) {
		this.ad = ad;
	}
	
	private String type;
	
	private String origin;
	private int hp;
	private int ad;
	private int shield;
	private String img;
	private String[][] skill;
	
}
