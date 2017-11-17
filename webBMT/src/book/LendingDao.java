package book;

import static login.Property.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import login.Property;

public class LendingDao {

	private Connection con;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps = null;


	//データベースからBook_list取得
	public ResultSet getBookList() throws SQLException {
		try {
			//JDBCドライバのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Property.url, user, pw);

			//SQL文を作成
			ps = con.prepareStatement("select*from book_list;");
			rs = ps.executeQuery();
		} catch (ClassNotFoundException ce) {
			//JDBCドライバが見つからなかった場合
			ce.printStackTrace();
		}
		return rs;
	}

	public void close() {
		try {
			con.close();
			if(con != null) {
				con.close();
			}
			if(ps != null) {
				ps.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}