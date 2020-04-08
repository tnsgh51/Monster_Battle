package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class DAO_Member implements DAO_Interface{
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private static DAO_Member mem;
	@Override
	public void insert(Object o) {
		if(connect()) {
			try {
				String sql="insert into member values(?,?,?)";
				stmt=conn.createStatement();
				if(stmt != null) {
					rs = stmt.executeQuery(sql);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}else {
			System.out.println("DB연결 실패");
			System.exit(0);
		}
	}

	@Override
	public void update(Object o) {
		
	}

	@Override
	public void delete(Object o) {
		DTO_Member m = (DTO_Member)o;
		
	}

	@Override
	public Object setAll() {
			ArrayList<DTO_Member> list= new ArrayList<>();
			String sql="SELECT * FROM member";
			if(connect()) {
				try {
					stmt=conn.createStatement();
					if(stmt != null) {
						rs = stmt.executeQuery(sql);
						while(rs.next()) {
							DTO_Member grade = new DTO_Member();
							grade.setId(rs.getString("id"));
							grade.setPassword(rs.getString("Password"));
							grade.setNickname(rs.getString("Nickname"));
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

	static { 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 로드 실패:" + e.getMessage());
		}
	}

	public static DAO_Member getInstance() {
		if (mem == null) {
			mem = new DAO_Member();
		}
		return mem;
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
