package Monster;

public class Monster_3 extends Monster{
	public Monster_3(){
		super.setOrigin("바람몬스터");
		super.setHp(60);
		super.setAd(100);
		super.setShield(1);
		super.setImg("바람.jpg");
		super.setType("바람");
		String[][] sk = {{"쪼기","140","0.65"},{"에어슬래시","170","0.5"},
				{"브레이브버드","300","0.25"},{"폭풍","800","0.1"}}; 	
		
		super.setSkill(sk);
	}
}
