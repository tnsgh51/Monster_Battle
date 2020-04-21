package Monster;

public class Monster_4 extends Monster{

	public Monster_4() {
		super.setOrigin("땅몬스터");
		super.setHp(100);
		super.setAd(20);
		super.setShield(5);
		super.setImg("땅.jpg");
		super.setType("땅");
		String[][] sk = {{"진흙뿌리기","30","0.65"},{"모래지옥","35","0.5"},
				{"대지의힘","65","0.25"},{"지진","135","0.1"}}; 	
		
		super.setSkill(sk);
	}

}
