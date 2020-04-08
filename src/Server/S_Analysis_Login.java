package Server;

import java.util.ArrayList;

public class S_Analysis_Login {
	private ArrayList<DTO_Member> mList = null;

	public S_Analysis_Login(S_Analysis s_Analysis) {
		mList = s_Analysis.getmList();
	}

	public boolean checkfirst(String k, S_TC s_tc) {
		for (DTO_Member m : mList) {
			String id = k.substring(0, k.indexOf(" "));
			String pwd = k.substring(k.indexOf(" ") + 1, k.length());
			if (m.checkIdPwd(id, pwd)) {
				m.setS_tc(s_tc);
				s_tc.send("/login success");
				
				for (int i = 0;i<mList.size();i++) {
					
					if (mList.get(i).getS_tc() != null) {
						if (!mList.get(i).getS_tc().equals(s_tc)) {
							mList.get(i).getS_tc().send("/room add " + m.getId());
							s_tc.send("/room add " + mList.get(i).getId());
						}
						
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				return true;
			}
		}
		s_tc.send("/login false");
		return false;
	}

	public void check(String k) {

	}

}
