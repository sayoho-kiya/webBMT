package login;
import static login.Property.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDao {

	private Connection con;
	private ResultSet rs;
	private PreparedStatement ps = null;


	//データベースから指定されたIDとパスワードを使ってユーザ情報を検索
	public ResultSet selectUser(String id, String pass) throws SQLException {
		try {
			//JDBCドライバのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Property.url, user, pw);

			//SQL文を作成
			ps = con.prepareStatement("select name,address from user where id=? and pass=?;");
			ps.setString(1, id);
			ps.setString(2, pass);
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