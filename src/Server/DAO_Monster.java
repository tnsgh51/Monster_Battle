package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_Monster implements DAO_Interface{
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private static DAO_Monster mom;
	
	static { 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패:" + e.getMessage());
		}
	}

	public static DAO_Monster getInstance() {
		if (mom == null) {
			mom = new DAO_Monster();
		}
		return mom;
	}

	private boolean connect() {
		boolean result = false;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "11111111");
			result = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	@Override
	public void insert(Object o) {
		DTO_Monster m = (DTO_Monster)o;
		if (connect()) {
			try {
				String sql = "insert into monster values('"+m.getId()+"','"+m.getNickname()+"','"+m.getOrigin()+"',"+m.getLv()+")";
				PreparedStatement psmt = conn.prepareStatement(sql);
				psmt.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e);
			}
		} else {
			System.out.println("connect ����");
		}

		
	}
	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Object setAll() {
		ArrayList<DTO_Monster> list= new ArrayList<>();
		String sql="SELECT * FROM monster";
		if(connect()) {
			try {
				stmt=conn.createStatement();
				if(stmt != null) {
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						DTO_Monster grade = new DTO_Monster();
						grade.setId(rs.getString("id"));
						grade.setNickname(rs.getString("Nickname"));
						grade.setOrigin(rs.getString("Origin"));
						grade.setLv(rs.getFloat("lv"));
						list.add(grade);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			System.out.println("DB연결 실패");
			System.exit(0);
		}

		return (Object)list;
	}

}
