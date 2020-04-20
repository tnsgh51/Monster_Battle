package Server;

import java.util.ArrayList;

public class S_Analysis_Battle {
	private ArrayList<BattleRoom> brList = null;

	public S_Analysis_Battle(S_Analysis s_Analysis) {
		brList = s_Analysis.getBrList();
	}

	private String msg;
	private S_TC s_tc;

	public void check(String msg, S_TC s_tc) {
		String w = msg.substring(0, msg.indexOf(" "));
		String k = msg.substring(msg.indexOf(" ") + 1, msg.length());
		String e = k.substring(0, k.indexOf(" "));
		this.msg = msg;
		this.s_tc = s_tc;

		if (checkturn()) {
			switch (w) {
			case "attack":
				for (int i = 0; i < brList.size(); i++) {
					if (s_tc.equals(brList.get(i).getI1().getS_tc())) {

						brList.get(i).getK().setId2_Monster_hp_now(brList.get(i).getK().getId2_now_monster(), brList
								.get(i).getK().getId2_Monster_hp_now(brList.get(i).getK().getId2_now_monster())
								- (int)(brList.get(i).getK().getId1_Monster_ad(brList.get(i).getK().getId1_now_monster())
										/ brList.get(i).getK()
												.getId2_Monster_shield(brList.get(i).getK().getId2_now_monster())));
						
						brList.get(i).getK().setSend_msg(brList.get(i).getK().getId1_Monster_nickname(brList.get(i).getK().getId1_now_monster())+"의 공격!\n"+
								(int)(brList.get(i).getK().getId1_Monster_ad(brList.get(i).getK().getId1_now_monster())
										/ brList.get(i).getK()
												.getId2_Monster_shield(brList.get(i).getK().getId2_now_monster()))+"의 데미지!!!\n" );
						
						brList.get(i).getK().setNow_turn(brList.get(i).getK().getId2());
					} else if (s_tc.equals(brList.get(i).getI2().getS_tc())) {
						brList.get(i).getK().setId1_Monster_hp_now(brList.get(i).getK().getId1_now_monster(), brList
								.get(i).getK().getId1_Monster_hp_now(brList.get(i).getK().getId1_now_monster())
								- (int)(brList.get(i).getK().getId2_Monster_ad(brList.get(i).getK().getId2_now_monster()))
										/ brList.get(i).getK()
												.getId1_Monster_shield(brList.get(i).getK().getId1_now_monster()));
						
						brList.get(i).getK().setSend_msg(brList.get(i).getK().getId2_Monster_nickname(brList.get(i).getK().getId2_now_monster())+"의 공격!\n"+
								(int)(brList.get(i).getK().getId2_Monster_ad(brList.get(i).getK().getId2_now_monster())
										/ brList.get(i).getK()
												.getId1_Monster_shield(brList.get(i).getK().getId1_now_monster()))+"의 데미지!!!\n" );
						
						
						brList.get(i).getK().setNow_turn(brList.get(i).getK().getId1());
					}
				}

				break;
			case "change":
				for (int i = 0; i < brList.size(); i++) {
					if (s_tc.equals(brList.get(i).getI1().getS_tc())) {
						brList.get(i).getK().setId1_now_monster(Integer.parseInt(e));

						brList.get(i).getK().setNow_turn(brList.get(i).getK().getId2());
					} else if (s_tc.equals(brList.get(i).getI2().getS_tc())) {
						brList.get(i).getK().setId2_now_monster(Integer.parseInt(e));

						brList.get(i).getK().setNow_turn(brList.get(i).getK().getId1());
					}
				}
				break;
			case "skill":

				break;
			case "surren":
				for (int i = 0; i < brList.size(); i++) {
					if (s_tc.equals(brList.get(i).getI1().getS_tc())) {
						brList.get(i).getI1().getS_tc().send("/battle win " + brList.get(i).getK().getId2() + "/ / /");
						brList.get(i).getI2().getS_tc().send("/battle win " + brList.get(i).getK().getId2() + "/ / /");
					
						brList.remove(i);
					}else if (s_tc.equals(brList.get(i).getI2().getS_tc())) {
						brList.get(i).getI1().getS_tc().send("/battle win " + brList.get(i).getK().getId1() + "/ / /");
						brList.get(i).getI2().getS_tc().send("/battle win " + brList.get(i).getK().getId1() + "/ / /");
						
						brList.remove(i);
					}
				}
				break;
			}

			battleResult();
			for (int i = 0; i < brList.size(); i++) {
				if (s_tc.equals(brList.get(i).getI1().getS_tc()) || s_tc.equals(brList.get(i).getI2().getS_tc())) {
					brList.get(i).getI1().getS_tc().sendO(brList.get(i).getK());
					brList.get(i).getI2().getS_tc().sendO(brList.get(i).getK());
					break;
				}
			}
		}
	}

	private void battleResult() {
		boolean t = true;
		
		for (int i = 0; i < brList.size(); i++) {
			if (s_tc.equals(brList.get(i).getI1().getS_tc())) {
				
				if (brList.get(i).getK().getId2_Monster_hp_now(brList.get(i).getK().getId2_now_monster()) <= 0) {
					for (int j = 0; j < 3; j++) {
						
						if (brList.get(i).getK().getId2_Monster_hp_now(j) > 0) {
							
							brList.get(i).getK().setSend_msg(brList.get(i).getK().getSend_msg()
									+brList.get(i).getK().getId2_Monster_nickname(brList.get(i).getK().getId2_now_monster())
									+"은 쓰러졌다.\n");
						
							t = false;
							brList.get(i).getK().setId2_now_monster(j);
							break;
						}
					}
					if (t) {
						brList.get(i).getI1().getS_tc().send("/battle win " + brList.get(i).getK().getId1() + "/ / /");
						brList.get(i).getI2().getS_tc().send("/battle win " + brList.get(i).getK().getId1() + "/ / /");
						brList.remove(i);

					}
				}
			} else if (s_tc.equals(brList.get(i).getI2().getS_tc())) {
				if (brList.get(i).getK().getId1_Monster_hp_now(brList.get(i).getK().getId1_now_monster()) <= 0) {
					for (int j = 0; j < 3; j++) {
						if (brList.get(i).getK().getId1_Monster_hp_now(j) > 0) {
							
							brList.get(i).getK().setSend_msg(brList.get(i).getK().getSend_msg()
									+brList.get(i).getK().getId1_Monster_nickname(brList.get(i).getK().getId1_now_monster())
									+"은 쓰러졌다.\n");
							t = false;
							brList.get(i).getK().setId1_now_monster(j);
							break;
						}
					}
					if (t) {
						brList.get(i).getI1().getS_tc().send("/battle win " + brList.get(i).getK().getId2() + "/ / /");
						brList.get(i).getI2().getS_tc().send("/battle win " + brList.get(i).getK().getId2() + "/ / /");
						brList.remove(i);
					}
				}
			}
		}
	}

	public boolean checkturn() {
		for (int i = 0; i < brList.size(); i++) {
			if (brList.get(i).getI1().getS_tc().equals(s_tc)) {
				if (brList.get(i).getK().getNow_turn().equals(brList.get(i).getI1().getId())) {
					
					return true;
				}
			} else if (brList.get(i).getI2().getS_tc().equals(s_tc)) {
				if (brList.get(i).getK().getNow_turn().equals(brList.get(i).getI2().getId())) {
					return true;
				}
			}
		}
		return false;

	}

}
