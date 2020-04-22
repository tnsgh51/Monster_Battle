package Monster;

public class Monster_1 extends Monster{
	
	
	public Monster_1(){
		super.setOrigin("불몬스터");
		super.setHp(100);
		super.setAd(40);
		super.setShield(2);
		super.setImg("불.jpg");
		super.setType("불");
		String[][] sk = {{"불꽃세례","50","65"},{"회오리불꽃","70","50"},
				{"화염자동차","130","25"},{"오버히트","300","10"}}; 	
		
		super.setSkill(sk);
	}
}
