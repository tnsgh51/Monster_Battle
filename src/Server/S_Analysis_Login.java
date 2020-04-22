package Server;

import java.util.ArrayList;

public class S_Analysis_Login {
	private ArrayList<DTO_Member> mList = null;

	public S_Analysis_Login(S_Analysis s_Analysis) {
		mList = s_Analysis.getmList();
	}

	public void check(String k, S_TC s_tc) {
		boolean t = true;
		for (DTO_Member m : mList) {
			String id = k.substring(0, k.indexOf(" "));
			String pwd = k.substring(k.indexOf(" ") + 1, k.length());
			if (m.checkIdPwd(id, pwd)) {
				if(m.getS_tc()==null) {
					m.setS_tc(s_tc);
					s_tc.send("/login success");
					t = false;
					for (int i = 0; i < mList.size(); i++) {
						
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
					break;
					
				}else {
					t=false;
					s_tc.send("/login already");
				}
			}
		}
		if (t) {
			s_tc.send("/login false");
		}
	}
}
