package Server;

import java.util.ArrayList;

public class S_Analysis_Battle {
	private ArrayList<BattleRoom> brList = null;

	public S_Analysis_Battle(S_Analysis s_Analysis) {
		brList = s_Analysis.getBrList();
	}

	public void check(String msg, S_TC s_tc) {
		String w = msg.substring(0, msg.indexOf(" "));
		String k = msg.substring(msg.indexOf(" ") + 1, msg.length());
		String e = k.substring(0, k.indexOf(" "));
		
		switch (w) {
		case "attack":
			for (int i = 0; i < brList.size(); i++) {
				if (s_tc.equals(brList.get(i).getI1().getS_tc()) ) {
					brList.get(i).getK().setId2_Monster_hp_now(brList.get(i).getK().getId2_now_monster(),brList.get(i).getK().getId2_Monster_hp_now(brList.get(i).getK().getId2_now_monster())
							-brList.get(i).getK().getId1_Monster_ad(brList.get(i).getK().getId1_now_monster()));
					brList.get(i).getK().setNow_turn(brList.get(i).getK().getId2());
				}else if(s_tc.equals(brList.get(i).getI2().getS_tc())) {
					brList.get(i).getK().setId1_Monster_hp_now(brList.get(i).getK().getId1_now_monster(),brList.get(i).getK().getId1_Monster_hp_now(brList.get(i).getK().getId1_now_monster())
							-brList.get(i).getK().getId2_Monster_ad(brList.get(i).getK().getId2_now_monster()));
					brList.get(i).getK().setNow_turn(brList.get(i).getK().getId1());
				}
			}
			
			break;
		case "change":
			for (int i = 0; i < brList.size(); i++) {
				if (s_tc.equals(brList.get(i).getI1().getS_tc()) ) {
					brList.get(i).getK().setId1_now_monster(Integer.parseInt(e));
					
				}else if(s_tc.equals(brList.get(i).getI2().getS_tc())) {
					brList.get(i).getK().setId2_now_monster(Integer.parseInt(e));
				}
			}
			break;
		}
		
		for (int i = 0; i < brList.size(); i++) {
			if (s_tc.equals(brList.get(i).getI1().getS_tc()) || s_tc.equals(brList.get(i).getI2().getS_tc())) {
				brList.get(i).getI1().getS_tc().sendO(brList.get(i).getK());
				brList.get(i).getI2().getS_tc().sendO(brList.get(i).getK());
				break;
			}
		}

	}

}
