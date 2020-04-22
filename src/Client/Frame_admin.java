package Client;

import javax.swing.JOptionPane;

import Send.TC_Object;

public class Frame_admin {
	private Frame_Battle fb = null;
	private Frame_Join fj = null;
	private Frame_Login fl = null;
	private Frame_Room fr = null;
	private static Frame_admin fa = null;
	private C_TC c_TC = null;
	
	
	public static Frame_admin getInstance() {
		if (fa == null) {
			fa = new Frame_admin();
		}
		return fa;
	}

	private Frame_admin() {
	}
	public void setfbField(TC_Object k) {
		fb.setField(k);
	}
	public void setfbId(String e) {
		fb.setId(e);
	}
	public void applySuccess() {
		fj.applySuccess();
	}
	public void setFL(Frame_Login login) {
		fl = login;
	}
	public void setFb(Frame_Battle fb) {
		this.fb = fb;
	}
	
	public void setFJ(Frame_Join join) {
		fj = join;
	}
	public void showLogin() {
		fl.setVisible(true);
	}
	public void Frame_RoomStart() {
		fr = new Frame_Room(this);
		fl.setVisible(false);
	}
	public void Frame_BattleEnd(String k) {
		JOptionPane.showOptionDialog(fr, k + "님의 승리!!", "Winner", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, "예");
		fb.dispose();
	}
	public void setCTC(C_TC c_TC) {
		this.c_TC = c_TC;
	}

	public void loginFalse(String k) {
		fl.loginfalse(k);
	}

	public void addFriend(String k) {
		fr.friendAdd(k);
	}

	public void addMsg(String k) {
		fr.addMsg(k);
	}
	
	public void sendMsg(String k) {
		c_TC.send(k);
	}

	public void battleapply(String k) {
		fr.ba(k);
	}
	public void idsuccess() {
		System.out.println("2번");
		fj.successCheck();
	}

	public void idfail(String k) {
		fj.failCheck(k);
	}

	public void deleteFriend(String k) {
		fr.friendDelete(k);
	}
}
