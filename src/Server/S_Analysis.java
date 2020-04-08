package Server;

import java.util.ArrayList;

public class S_Analysis {
	
	public ArrayList<DTO_Member> getmList() {
		return mList;
	}

	private static S_Analysis s = null;
	private ArrayList<DTO_Member> mList = null;
	private DAO_Interface DAO = null;
	private S_Analysis_Login sal = null;
	private S_Analysis_Battle sab = null;
	private S_Analysis_Room sar = null;
	private S_Analysis_Join saj = null;
	
	public static S_Analysis getInstance() {
		if(s== null) {
			s = new S_Analysis();
		}
		return s;
	}
	
	private S_Analysis() {
		setting();
	}
	private void setting() {	
		DAO = new DAO_Member();
		mList = (ArrayList<DTO_Member>)DAO.setAll();
		sal = new S_Analysis_Login(this);
		sab = new S_Analysis_Battle(this);
		sar = new S_Analysis_Room(this);
		saj = new S_Analysis_Join(this);
		System.out.println("분석 준비 완료");
	}
	
	public boolean checkfirst(String msg,S_TC s_tc) {
		String w = msg.substring(0,msg.indexOf(" "));
		String k = msg.substring(msg.indexOf(" ")+1,msg.length());
		return sal.checkfirst(k,s_tc);
	}
	public void check(String msg,S_TC s_tc) {
		System.out.println(msg);
		String w = msg.substring(0,msg.indexOf(" "));
		String k = msg.substring(msg.indexOf(" ")+1,msg.length());
		switch(w){
		case "/login":
			sal.check(k);
			break;
		case "/room":
			sar.check(k,s_tc);
			break;
		case "/battle":
			sab.check(k);
			break;
		case "/join":
			saj.check(k);
			break;
		}
	}
	
	
}
