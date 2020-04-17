package Client;

import Send.TC_Object;

public class C_Analysis_Battle {
	private Frame_admin fa = Frame_admin.getInstance();

	public void check(String msg) {
		String w = msg.substring(0, msg.indexOf(" "));
		System.out.println(w);
		String k = msg.substring(msg.indexOf(" ") + 1, msg.length());
		System.out.println(k);
		String e = k.substring(0, k.indexOf(" "));
		System.out.println(e);
		if (w.equals("start")) {
			Frame_Battle fb = new Frame_Battle();
			fa.setFb(fb);
			
			fa.setfbId(e);
		}
	}

	public void check(TC_Object k) {
		fa.setfbField(k);
	}

}
