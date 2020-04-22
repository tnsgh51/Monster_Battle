package Monster;

public class Monster_5 extends Monster{

	public Monster_5() {
		super.setOrigin("닥트리오");
		super.setHp(40);
		super.setAd(20);
		super.setShield(5);
		super.setImg("땅2.jpg");
		super.setType("땅");
		String[][] sk = {{"진흙뿌리기","30","65"},{"모래지옥","35","50"},
				{"대지의힘","65","25"},{"지진","135","10"}}; 	
		
		super.setSkill(sk);
	}

}
