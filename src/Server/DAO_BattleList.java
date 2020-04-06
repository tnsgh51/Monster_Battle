package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO_BattleList implements DAO_Interface{
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private static DAO_BattleList ba;
	@Override
	public void insert(Object o) {
		// TODO Auto-generated method stub
		
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
	public ArrayList<DTO_BattleList> setAll() {
			ArrayList<DTO_BattleList> list= new ArrayList<>();
			String sql="SELECT * FROM member";
			if(connect()) {
				try {
					stmt=conn.createStatement();
					if(stmt != null) {
						rs = stmt.executeQuery(sql);
						while(rs.next()) {
							DTO_BattleList grade = new DTO_BattleList();
							grade.setId(rs.getString("id"));
							grade.setResult(""+(char)rs.getInt("Result"));
							grade.setOpponent(rs.getString("Opponent"));
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
			return list;
	}

	static { 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패:" + e.getMessage());
		}
	}

	public static DAO_BattleList getInstance() {
		if (ba == null) {
			ba = new DAO_BattleList();
		}
		return ba;
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


}
