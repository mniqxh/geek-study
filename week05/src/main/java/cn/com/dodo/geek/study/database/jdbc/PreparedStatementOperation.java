package cn.com.dodo.geek.study.database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatementOperation {

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
			// 批量新增
			batchInsert();
			// 批量删除
			batchDelete();
		} finally {
			if (con != null) {
				con.close();
			}
		}

	}

	private static void print(String pos) throws Exception {
		print(pos, true);
	}

	private static void print(String pos, boolean same) throws Exception {
		String sql = "select * from country";
		System.out.println(pos + "======================");
		Connection querycon;
		boolean common = true;
		if (same) {
			querycon = con;
		} else {
			querycon = DriverManager.getConnection(url, user, password);
			common = false;
		}
		try (PreparedStatement pstmt = querycon.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
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
		} finally {
			if (!common && querycon != null) {
				try {
					querycon.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void delete() throws Exception {
		String sql = "delete from country where id=?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, 5);
			pstmt.execute();
		} catch (Exception e) {
			throw e;
		}
		print("删除后");
	}

	private static void add() throws Exception {
		String sql = "insert into `country`(`id`,`country_name`,`country_code`) values (?,?,?)";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, 5);
			pstmt.setString(2, "法国");
			pstmt.setString(3, "FR2");
			pstmt.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
		print("增加后");
	}

	private static void update() throws Exception {
		String sql = "update country set country_code=? where id=?";
		try (PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, "FR");
			pstmt.setInt(2, 5);
			pstmt.execute();
		} catch (Exception e) {
			throw e;
		}
		print("更新后");
	}

	private static void batchInsert() throws Exception {
		try (Statement stmt = con.createStatement()) {
			con.setAutoCommit(false);
			for (int i = 0; i < 5; i++) {
				String sql = "insert into `country`(`id`,`country_name`,`country_code`) values (" + (6 + i) + ",'国家" + i
						+ "','CODE" + i + "')";
				stmt.addBatch(sql);
			}
			stmt.executeBatch();
			print("批量增加提交前", false);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		}
		print("批量增加提交后");
	}
	
	private static void batchDelete() throws Exception {
		try (Statement stmt = con.createStatement()) {
			con.setAutoCommit(false);
			for (int i = 0; i < 5; i++) {
				String sql = "delete from country where id=" + (6 + i);
				stmt.addBatch(sql);
			}
			stmt.executeBatch();
			print("批量删除提交前", false);
			con.commit();
		} catch (Exception e) {
			con.rollback();
			throw e;
		}
		print("批量删除提交后");
	}

}
