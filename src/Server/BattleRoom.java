package Server;

import java.util.ArrayList;
import java.util.Random;

import Monster.Monster;
import Send.TC_Object;

public class BattleRoom {
	public TC_Object getK() {
		return k;
	}

	public void setK() {

	}

	public DTO_Member getI1() {
		return i1;
	}

	public void setI1(DTO_Member i1) {
		this.i1 = i1;
	}

	public DTO_Member getI2() {
		return i2;
	}

	public void setI2(DTO_Member i2) {
		this.i2 = i2;
	}

	private TC_Object k = new TC_Object();
	private DTO_Member i1 = null;
	private DTO_Member i2 = null;

	BattleRoom(DTO_Member i1, DTO_Member i2) {
		this.i1 = i1;
		this.i2 = i2;
	}

	public void setBattle(ArrayList<Monster> kindMonster, ArrayList<DTO_Monster> monsterList) {
		int id1 = 0, id2 = 0;
		Random r = new Random();

		for (DTO_Monster monster : monsterList) {

			if (monster.getId().equals(i1.getId())) {
				for (Monster MM : kindMonster) {
					if (monster.getOrigin().equals(MM.getOrigin())) {
						k.setId1(i1.getId(), id1, monster.getNickname(), monster.getOrigin(), monster.getLv(),
								(int) (monster.getLv() * MM.getAd()), (int) (monster.getLv() * MM.getShield()),
								(int) (monster.getLv() * MM.getHp()), (int) (monster.getLv() * MM.getHp()),
								MM.getImg());
						break;
					}

				}
				id1++;
			}
			
			if (monster.getId().equals(i2.getId())) {
				for (Monster MM : kindMonster) {
					if (monster.getOrigin().equals(MM.getOrigin())) {
						k.setId2(i2.getId(), id2, monster.getNickname(), monster.getOrigin(), monster.getLv(),
								(int) (monster.getLv() * MM.getAd()), (int) (monster.getLv() * MM.getShield()),
								(int) (monster.getLv() * MM.getHp()), (int) (monster.getLv() * MM.getHp()),
								MM.getImg());
						break;
					}

				}
				id2++;
			}

		}

		k.setFirst(r.nextInt(2));

	}
}
