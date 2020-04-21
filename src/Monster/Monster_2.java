package Monster;

public class Monster_2 extends Monster{

	public Monster_2(){
		super.setOrigin("물몬스터");
		super.setHp(70);
		super.setAd(30);
		super.setShield(4);
		super.setImg("물.jpg");
		super.setType("물");
		String[][] sk = {{"물대포","40","0.65"},{"파도타기","50","0.5"},
				{"물의파동","90","0.25"},{"하이드로펌프","200","0.1"}}; 	
		
		super.setSkill(sk);
	}
}
