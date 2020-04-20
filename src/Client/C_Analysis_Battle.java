package Client;

import Send.TC_Object;

public class C_Analysis_Battle {
	private Frame_admin fa = Frame_admin.getInstance();

	public void check(String msg) {
		String w = msg.substring(0, msg.indexOf(" "));
		String k = msg.substring(msg.indexOf(" ") + 1, msg.length());
		String e = k.substring(0, k.indexOf(" "));
		if (w.equals("start")) {
			Frame_Battle fb = new Frame_Battle();
			fa.setFb(fb);
			
			fa.setfbId(e);
		}else if (w.equals("win")) {
			fa.Frame_BattleEnd(e);
		}
	}

	public void check(TC_Object k) {
		fa.setfbField(k);
	}

}
