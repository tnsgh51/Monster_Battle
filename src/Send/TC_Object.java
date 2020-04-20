package Send;

import java.io.Serializable;

public class TC_Object implements Serializable {
	


	public String getSend_msg() {
		return send_msg;
	}

	public void setSend_msg(String send_msg) {
		this.send_msg = send_msg;
	}

	public String[] getId1_Monster_nickname() {
		return id1_Monster_nickname;
	}

	public int[] getId1_Monster_hp() {
		return id1_Monster_hp;
	}

	public int[] getId1_Monster_hp_now() {
		return id1_Monster_hp_now;
	}

	public String[] getId2_Monster_nickname() {
		return id2_Monster_nickname;
	}

	public int[] getId2_Monster_hp() {
		return id2_Monster_hp;
	}

	public int[] getId2_Monster_hp_now() {
		return id2_Monster_hp_now;
	}

	public String getId1_Monster_nickname(int i) {
		return id1_Monster_nickname[i];
	}

	public void setId1_Monster_nickname(String[] id1_Monster_nickname) {
		this.id1_Monster_nickname = id1_Monster_nickname;
	}

	public String getId1_Monster_origin(int i) {
		return id1_Monster_origin[i];
	}

	public void setId1_Monster_origin(String[] id1_Monster_origin) {
		this.id1_Monster_origin = id1_Monster_origin;
	}

	public float getId1_Monster_Lv(int i) {
		return id1_Monster_Lv[i];
	}

	public void setId1_Monster_Lv(float[] id1_Monster_Lv) {
		this.id1_Monster_Lv = id1_Monster_Lv;
	}

	public int getId1_Monster_ad(int i) {
		return id1_Monster_ad[i];
	}

	public void setId1_Monster_ad(int[] id1_Monster_ad) {
		this.id1_Monster_ad = id1_Monster_ad;
	}

	public int getId1_Monster_shield(int i) {
		return id1_Monster_shield[i];
	}

	public void setId1_Monster_shield(int[] id1_Monster_shield) {
		this.id1_Monster_shield = id1_Monster_shield;
	}

	public int getId1_Monster_hp(int i) {
		return id1_Monster_hp[i];
	}

	public void setId1_Monster_hp(int[] id1_Monster_hp) {
		this.id1_Monster_hp = id1_Monster_hp;
	}

	public int getId1_Monster_hp_now(int i) {
		return id1_Monster_hp_now[i];
	}

	public void setId1_Monster_hp_now(int[] id1_Monster_hp_now) {
		this.id1_Monster_hp_now = id1_Monster_hp_now;
	}

	public String getId1_Monster_img(int i) {
		return id1_Monster_img[i];
	}

	public void setId1_Monster_img(String[] id1_Monster_img) {
		this.id1_Monster_img = id1_Monster_img;
	}

	public int getId1_now_monster() {
		return id1_now_monster;
	}

	public void setId1_now_monster(int id1_now_monster) {
		this.id1_now_monster = id1_now_monster;
	}

	public String getId2_Monster_nickname(int i) {
		return id2_Monster_nickname[i];
	}

	public void setId2_Monster_nickname(String[] id2_Monster_nickname) {
		this.id2_Monster_nickname = id2_Monster_nickname;
	}

	public String getId2_Monster_origin(int i) {
		return id2_Monster_origin[i];
	}

	public void setId2_Monster_origin(String[] id2_Monster_origin) {
		this.id2_Monster_origin = id2_Monster_origin;
	}

	public float getId2_Monster_Lv(int i) {
		return id2_Monster_Lv[i];
	}

	public void setId2_Monster_Lv(float[] id2_Monster_Lv) {
		this.id2_Monster_Lv = id2_Monster_Lv;
	}

	public int getId2_Monster_ad(int i) {
		return id2_Monster_ad[i];
	}

	public void setId2_Monster_ad(int[] id2_Monster_ad) {
		this.id2_Monster_ad = id2_Monster_ad;
	}

	public int getId2_Monster_shield(int i) {
		return id2_Monster_shield[i];
	}

	public void setId2_Monster_shield(int[] id2_Monster_shield) {
		this.id2_Monster_shield = id2_Monster_shield;
	}

	public int getId2_Monster_hp(int i) {
		return id2_Monster_hp[i];
	}

	public void setId2_Monster_hp(int[] id2_Monster_hp) {
		this.id2_Monster_hp = id2_Monster_hp;
	}

	public int getId2_Monster_hp_now(int i) {
		return id2_Monster_hp_now[i];
	}

	public void setId2_Monster_hp_now(int[] id2_Monster_hp_now) {
		this.id2_Monster_hp_now = id2_Monster_hp_now;
	}

	public void setId2_Monster_hp_now(int i, int k) {
		this.id2_Monster_hp_now[i] = k;
	}

	public void setId1_Monster_hp_now(int i, int k) {
		this.id1_Monster_hp_now[i] = k;
	}

	public String getId2_Monster_img(int i) {
		return id2_Monster_img[i];
	}

	public void setId2_Monster_img(String[] id2_Monster_img) {
		this.id2_Monster_img = id2_Monster_img;
	}

	public int getId2_now_monster() {
		return id2_now_monster;
	}

	public void setId2_now_monster(int id2_now_monster) {
		this.id2_now_monster = id2_now_monster;
	}

	public String getNow_turn() {
		return now_turn;
	}

	public void setNow_turn(String now_turn) {
		this.now_turn = now_turn;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public void setId2(String id2) {
		this.id2 = id2;
	}

	public String getId1() {
		return id1;
	}

	public String getId2() {
		return id2;
	}

	private String id1;

	private String[] id1_Monster_nickname = new String[3];
	private String[] id1_Monster_origin = new String[3];
	private float[] id1_Monster_Lv = new float[3];
	private int[] id1_Monster_ad = new int[3];
	private int[] id1_Monster_shield = new int[3];
	private int[] id1_Monster_hp = new int[3];
	private int[] id1_Monster_hp_now = new int[3];
	private String[] id1_Monster_img = new String[3];
	private int id1_now_monster = 0;

	private String id2;

	private String[] id2_Monster_nickname = new String[3];
	private String[] id2_Monster_origin = new String[3];
	private float[] id2_Monster_Lv = new float[3];
	private int[] id2_Monster_ad = new int[3];
	private int[] id2_Monster_shield = new int[3];
	private int[] id2_Monster_hp = new int[3];
	private int[] id2_Monster_hp_now = new int[3];
	private String[] id2_Monster_img = new String[3];
	private int id2_now_monster = 0;

	private String now_turn;
	private String send_msg;

	public void setId1(String id, int k, String nn, String o, float lv, int a, int b, int c, int d, String img) {
		id1 = id;
		id1_Monster_nickname[k] = nn;
		id1_Monster_origin[k] = o;
		id1_Monster_Lv[k] = lv;
		id1_Monster_ad[k] = a;
		id1_Monster_shield[k] = b;
		id1_Monster_hp[k] = c;
		id1_Monster_hp_now[k] = d;
		id1_Monster_img[k] = img;
	}

	public void setId2(String id, int k, String nn, String o, float lv, int a, int b, int c, int d, String img) {
		id2 = id;
		id2_Monster_nickname[k] = nn;
		id2_Monster_origin[k] = o;
		id2_Monster_Lv[k] = lv;
		id2_Monster_ad[k] = a;
		id2_Monster_shield[k] = b;
		id2_Monster_hp[k] = c;
		id2_Monster_hp_now[k] = d;
		id2_Monster_img[k] = img;
	}

	public void setFirst(int r) {
		if (r == 0) {
			now_turn = id1;
		} else {
			now_turn = id2;
		}
	}
}
