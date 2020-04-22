package Server;

import java.util.ArrayList;

import Monster.Monster;
import Monster.Monster_1;
import Monster.Monster_2;
import Monster.Monster_3;
import Monster.Monster_4;
import Monster.Monster_5;

public class S_Analysis {

	public ArrayList<DTO_Member> getmList() {
		return mList;
	}

	public ArrayList<DTO_Monster> getMonsterList() {
		return monsterList;
	}

	public ArrayList<Monster> getKindMonster() {
		return kindMonster;
	}

	public ArrayList<BattleRoom> getBrList() {
		return brList;
	}

	public ArrayList<DTO_BattleList> getBattleList() {
		return battleList;
	}

	private static S_Analysis s = null;
	private ArrayList<DTO_Member> mList = null;
	private ArrayList<DTO_Monster> monsterList = null;
	private ArrayList<Monster> kindMonster = new ArrayList<>();
	private ArrayList<DTO_BattleList> battleList = null;
	private ArrayList<BattleRoom> brList = new ArrayList<BattleRoom>();

	private DAO_Interface DAO = null;
	private S_Analysis_Login sal = null;
	private S_Analysis_Battle sab = null;
	private S_Analysis_Room sar = null;
	private S_Analysis_Join saj = null;

	public void logout(S_TC stc) {
		for (DTO_Member ii : mList) {
			if (ii.getS_tc() != null) {
				if (ii.getS_tc().equals(stc)) {
					for (int i = 0; i < brList.size(); i++) {
						if (stc.equals(brList.get(i).getI1().getS_tc())) {
							brList.get(i).getI2().getS_tc()
									.send("/battle win " + brList.get(i).getK().getId2() + "/ / /");
							sab.battleSave2(i);
							brList.remove(i);
							break;
						} else if (stc.equals(brList.get(i).getI2().getS_tc())) {
							brList.get(i).getI1().getS_tc()
									.send("/battle win " + brList.get(i).getK().getId1() + "/ / /");
							sab.battleSave1(i);
							brList.remove(i);
							break;
						}
					}
					ii.setS_tc(null);

					for (DTO_Member kk : mList) {
						if (kk.getS_tc() != null) {
							kk.getS_tc().send("/room delete " + ii.getId());
						}

					}
					break;
				}
			}
		}
	}

	public static S_Analysis getInstance() {
		if (s == null) {
			s = new S_Analysis();
		}
		return s;
	}

	private S_Analysis() {
		setting();
	}

	private void setting() {
		DAO = new DAO_Member();
		mList = (ArrayList<DTO_Member>) DAO.setAll();
		DAO = new DAO_Monster();
		monsterList = (ArrayList<DTO_Monster>) DAO.setAll();
		DAO = new DAO_BattleList();
		battleList = (ArrayList<DTO_BattleList>) DAO.setAll();
		for (DTO_Member m : mList) {
			for (DTO_BattleList b : battleList) {
				if (m.getId().equals(b.getId())) {
					m.addMyList(b);
				}
			}
		}
		settingMonster();

		sal = new S_Analysis_Login(this);
		sab = new S_Analysis_Battle(this);
		sar = new S_Analysis_Room(this);
		saj = new S_Analysis_Join(this);
		System.out.println("분석 준비 완료");
	}

	private void settingMonster() {

		Monster k = new Monster_1();
		kindMonster.add(k);

		k = new Monster_2();
		kindMonster.add(k);

		k = new Monster_3();
		kindMonster.add(k);

		k = new Monster_4();
		kindMonster.add(k);

		k = new Monster_5();
		kindMonster.add(k);

	}

	public void check(String msg, S_TC s_tc) {
		String w = msg.substring(0, msg.indexOf(" "));
		String k = msg.substring(msg.indexOf(" ") + 1, msg.length());
		switch (w) {
		case "/login":
			sal.check(k, s_tc);
			break;
		case "/room":
			sar.check(k, s_tc);
			break;
		case "/battle":
			sab.check(k, s_tc);
			break;
		case "/join":
			saj.check(k, s_tc);
			break;
		}
	}

}
