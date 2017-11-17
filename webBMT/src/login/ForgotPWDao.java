package login;
import static login.Property.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ForgotPWDao {

	private Connection con;
	private ResultSet rs;
	private Statement st;


	//データベースに登録
	public ResultSet registerUser(String name, String mailaddress) throws SQLException {
		try {
			//JDBCドライバのロード
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(Property.url, user, pw);

			//SQL文を作成
			String sql = "select id,pass from user where name='" + name + "' and address='" + mailaddress + "';";
			st = con.createStatement();
			rs = st.executeQuery(sql);
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

		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

}