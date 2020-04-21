package Send;

import java.io.Serializable;
import java.util.ArrayList;

public class TC_People implements Serializable {
	public void setRecord() {
		int r = 0;
		int w = 0;
		for (DTO_BattleList k : mybattleList) {
			if (k.getResult().equals("1")) {
				r = r + 1;
			} else {
				w = w + 1;
			}
		}
		score = w + " 승" + r + " 패";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public ArrayList<DTO_BattleList> getMybattleList() {
		return mybattleList;
	}

	public void setMybattleList(ArrayList<DTO_BattleList> mybattleList) {
		this.mybattleList = mybattleList;
	}

	private ArrayList<DTO_BattleList> mybattleList = null;
	private String score = "0승 0패";
	private String id = "";
	private String nickname = "";

	public TC_People() {

	}

}
