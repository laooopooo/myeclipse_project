package bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbDao {
	private String driver;
	private String url;
	private String user;
	private String pass;
	private Connection conn;

	public DbDao(String driver, String url, String user, String pass) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pass = pass;
	}

	public Connection getConn() throws Exception {
		if (conn == null) {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		}
		return conn;
	}
	
	public void closeConn()throws Exception{
		if(conn!=null){
			conn.close();
		}
	}

	public ResultSet query(String sql, Object... args) throws Exception {
		PreparedStatement ps = getConn().prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			ps.setObject(i + 1, args[i]);
		}
		return ps.executeQuery();
	}

	public int update(String sql, Object... args) throws Exception {
		PreparedStatement ps = getConn().prepareStatement(sql);
		for (int i = 0; i < args.length; i++) {
			ps.setObject(i + 1, args[i]);
		}
		return ps.executeUpdate();
	}

}
