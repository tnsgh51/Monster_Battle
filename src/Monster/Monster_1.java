package Monster;

public class Monster_1 extends Monster{
	
	
	public Monster_1(){
		super.setOrigin("1번");
		super.setHp(100);
		super.setAd(20);
		super.setShield(4);
		super.setImg("1번.jpg");
		String[][] sk = {{"할퀴기","150","0.8"},{"할퀴기","200","0.4"},
				{"할퀴기","300","0.2"},{"할퀴기","500","0.1"}}; 	
		
		super.setSkill(sk);
	}
}
