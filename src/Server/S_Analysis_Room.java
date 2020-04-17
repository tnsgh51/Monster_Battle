package Server;

import java.util.ArrayList;

import Monster.Monster;

public class S_Analysis_Room {
	private ArrayList<DTO_Member> mList = null;
	private ArrayList<BattleRoom> brList = null;
	private ArrayList<DTO_Monster> monsterList = null;
	private ArrayList<Monster> kindMonster = null;

	public S_Analysis_Room(S_Analysis s_Analysis) {
		mList = s_Analysis.getmList();
		brList = s_Analysis.getBrList();
		monsterList = s_Analysis.getMonsterList();
		kindMonster = s_Analysis.getKindMonster();

	}

	public void check(String msg, S_TC s_tc) {
		String w = msg.substring(0, msg.indexOf(" "));
		String k = msg.substring(msg.indexOf(" ") + 1, msg.length());
		switch (w) {
		case "msg":
			for (DTO_Member m : mList) {
				if (m.getS_tc() != null) {
					if (m.getS_tc().equals(s_tc)) {
						for (DTO_Member ee : mList) {
							if (ee.getS_tc() != null) {
								ee.getS_tc().send("/room msg [" + m.getId() + "] " + k);
							}
						}
					}
				}
			}
			break;
		case "battle":
			for (DTO_Member m : mList) {
				if (m.getS_tc() != null) {
					if (m.getS_tc().equals(s_tc)) {
						for (DTO_Member ee : mList) {
							if (ee.getS_tc() != null) {
								if (ee.getId().equals(k)) {
									ee.getS_tc().send("/room battle apply " + m.getId());
									BattleRoom tco = new BattleRoom(m, ee);
									brList.add(tco);
									
								}
							}
						}
					}
				}
			}
			break;
		case "accept":
			for (int i = 0; i < brList.size(); i++) {
				if (s_tc.equals(brList.get(i).getI1().getS_tc()) || s_tc.equals(brList.get(i).getI2().getS_tc())) {
					
					brList.get(i).getI1().getS_tc().send("/battle start "+brList.get(i).getI1().getId()+" / ");
					brList.get(i).getI2().getS_tc().send("/battle start "+brList.get(i).getI2().getId()+" / ");
					
					brList.get(i).setBattle(kindMonster, monsterList);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					brList.get(i).getI1().getS_tc().sendO(brList.get(i).getK());
					brList.get(i).getI2().getS_tc().sendO(brList.get(i).getK());
					break;
				}
			}

			break;
		case "reject":
			for (int i = 0; i < brList.size(); i++) {
				if (s_tc.equals(brList.get(i).getI1().getS_tc()) || s_tc.equals(brList.get(i).getI2().getS_tc())) {
					brList.remove(i);
				}
			}
			break;
		}
	}

}
