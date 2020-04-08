package Server;

import java.util.ArrayList;

public class S_Analysis_Room {
	private ArrayList<DTO_Member> mList = null;

	public S_Analysis_Room(S_Analysis s_Analysis) {

		mList = s_Analysis.getmList();
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
								}
							}
						}
					}
				}
			}
			break;
		}
	}

}
