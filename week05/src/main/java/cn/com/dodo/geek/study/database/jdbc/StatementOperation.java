package cn.com.dodo.geek.study.database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StatementOperation {

	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://192.168.56.2:3306/geek?useUnicode=true&characterEncoding=UTF-8&useSSL=false";
	private static String user = "root";
	private static String password = "Root@123456";

	private static Connection con;

	static {
		try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		try {
			Class.forName(driver);

			// 查询
			print("原表值");
			// 删除
			delete();
			// 增加
			add();
			// 更新
			update();
		} finally {
			if (con != null) {
				con.close();
			}
		}

	}

	private static void print(String pos) throws Exception {
		String sql = "select * from country";
		System.out.println(pos + "======================");
		try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			int columnCount = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < columnCount; i++) {
					sb.append(rs.getObject(i + 1));
					sb.append("\t");
				}
				System.out.println(sb);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	private static void delete() throws Exception {
		String sql = "delete from country where id=5";
		sqlExecutor(sql);
		print("删除后");
	}

	private static void add() throws Exception {
		String sql = "insert into `country`(`id`,`country_name`,`country_code`) values (5,'法国','FR2')";
		sqlExecutor(sql);
		print("增加后");
	}

	private static void update() throws Exception {
		String sql = "update country set country_code='FR' where id=5";
		sqlExecutor(sql);
		print("更新后");
	}

	private static void sqlExecutor(String sql) throws Exception {
		try (Statement stmt = con.createStatement()) {
			stmt.execute(sql);
		} catch (Exception e) {
			throw e;
		}
	}

}
