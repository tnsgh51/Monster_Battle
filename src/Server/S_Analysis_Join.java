package Server;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class S_Analysis_Join {
	private ArrayList<DTO_Member> mList = null;
	private S_TC s = null;
	private DTO_Member tt = new DTO_Member();
	private ArrayList<DTO_Monster> monsterList = null;

	public S_Analysis_Join(S_Analysis s_Analysis) {
		mList = s_Analysis.getmList();
		monsterList = s_Analysis.getMonsterList();
	}

	public void check(String msg, S_TC s_tc) {
		String w = msg.substring(0, msg.indexOf(" "));
		String k = msg.substring(msg.indexOf(" ") + 1, msg.length());
		s = s_tc;
		switch (w) {
		case "idcheck":
			idcheck(k);
			break;
		case "apply":
			apply(k);
			break;
		}
	}

	public void apply(String msg) {
		String w = msg.substring(0, msg.indexOf(" "));
		String k = msg.substring(msg.indexOf(" ") + 1, msg.length());
		boolean t = true;
		if (w.length() < 6 || w.length() > 10) {
			t = false;
		}
		if (t) {
			for (DTO_Member e : mList) {
				if (e.getId().equals(w)) {
					t = false;
				}
			}
		}
		if (t) {
			for (int i = 0; i < w.length(); i++) {
				if ((w.charAt(i) >= 48 && w.charAt(i) <= 57) || (w.charAt(i) >= 65 && w.charAt(i) <= 122)) {

				} else {
					t = false;
					break;
				}
			}
		}

		if (t) {
			tt.setId(w);
			pwdcheck(k);
		}
	}

	private void pwdcheck(String msg) {
		String w = msg.substring(0, msg.indexOf(" "));
		String k = msg.substring(msg.indexOf(" ") + 1, msg.length());
		if (w.length() == 4) {
			tt.setPassword(w);
			nncheck(k);
		}
	}

	private void nncheck(String msg) {
		String w = msg.substring(0, msg.indexOf(" "));
		String k = msg.substring(msg.indexOf(" ") + 1, msg.length());
		if (w.length() < 10) {
			tt.setNickname(w);
			setMonster(k);
		}
	}

	private void setMonster(String msg) {
		StringTokenizer st = new StringTokenizer(msg, " ");

		if (st.countTokens() == 7) {
			DAO_Interface k = DAO_Member.getInstance();
			mList.add(tt);
			k.insert((Object) tt);
			k = DAO_Monster.getInstance();
			for (int i = 0; i < 3; i++) {
				DTO_Monster mst = new DTO_Monster();

				mst.setId(tt.getId());

				mst.setNickname(st.nextToken());
				mst.setOrigin(st.nextToken());

				monsterList.add(mst);// db에 저장도 같이해야됨
				k.insert((Object) mst);
				System.out.println("dd");
			}

			s.send("/join apply /");
		}

	}

	public void idcheck(String msg) {
		boolean t = true;
		if (msg.length() < 6 || msg.length() > 10) {
			t = false;
			s.send("/join idcheck fail 글자수가 부적합합니다.");
		}
		if (t) {
			for (DTO_Member e : mList) {
				if (e.getId().equals(msg)) {
					t = false;
					s.send("/join idcheck fail 중복아이디 입니다.");
				}
			}
		}
		if (t) {
			for (int i = 0; i < msg.length(); i++) {
				if ((msg.charAt(i) >= 48 && msg.charAt(i) <= 57) || (msg.charAt(i) >= 65 && msg.charAt(i) <= 122)) {

				} else {
					s.send("/join idcheck fail 숫자 또는 영어만 사용해주세요.");
					t = false;
					break;
				}
			}
		}

		if (t) {
			s.send("/join idcheck success 성공");
		}
	}

}
