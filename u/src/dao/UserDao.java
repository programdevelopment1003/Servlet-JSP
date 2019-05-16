package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.LoginDto;
import dto.UserDto;

public class UserDao {

	public LoginDto login(String mail,String pass) {
		LoginDto dto = null;

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			//データベースの接続
			Class.forName("com.mysql.jdbc.Driver");

			//*******
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost/jsa04", "pma", "Centosadmin1!");

			//*******
			stmt = con.prepareStatement("SELECT * FROM user WHERE mail = ? and pass = ?");
			stmt.setString(1,mail);
			stmt.setString(2,pass);
			//SQLを発行して、ユーザーテーブルからデータ取得
			rs = stmt.executeQuery();
System.out.println("userdao***");
			while(rs.next()){
				//*******
				dto = new LoginDto();
				dto.setId(rs.getInt("userId"));
				dto.setAuthority(rs.getString("authority"));
				dto.setName(rs.getString("name"));
				dto.setMail(rs.getString("mail"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs != null){rs.close();}
				if(stmt != null){stmt.close();}
				if(con != null){con.close();}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		//データベースの接続

		//SQLを発行して、ユーザーテーブルからデータ取得

		return dto;
	}
	public UserDto getUser(String mail) throws Exception{
		UserDto dto = null;

		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try{
			//データベースの接続
			Class.forName("com.mysql.jdbc.Driver");

			//*******
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost/jsa04", "pma", "Centosadmin1!");

			//*******
			stmt = con.prepareStatement("SELECT * FROM user WHERE mail = ? and pass = ?");
			stmt.setString(1,mail);

			rs = stmt.executeQuery();

			while(rs.next()){
				UserDto userDto = new UserDto();
				dto.setuserId(rs.getInt("userId"));
				dto.setpass(rs.getString("pass"));
				dto.setname(rs.getString("name"));
				dto.setmail(rs.getString("mail"));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			try{
				if(rs != null){rs.close();}
				if(stmt != null){stmt.close();}
				if(con != null){con.close();}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		//データベースの接続

		//SQLを発行して、ユーザーテーブルからデータ取得

		return dto;
	}


	public void insert(UserDto userdto) throws Exception{
		Connection con = null;
		PreparedStatement stmt = null;

		System.out.println("**"+userdto.getmail()+userdto.getname());



		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost/jsa04","pma","Centosadmin1!");
			stmt = con.prepareStatement("INSERT INTO user (mail,pass,name,authority) VALUES(?,?,?,?)");

			stmt.setString(1, userdto.getmail());
			stmt.setString(2, userdto.getpass());
			stmt.setString(3, userdto.getname());
			stmt.setString(4,"U");

			stmt.executeUpdate();


		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try {
				if( stmt != null ) {stmt.close();}
				if( stmt != null ) {con.close(); }
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	/**
	 * ユーザーの更新処理
	 *
	 * @param userdto
	 */
	public void update(UserDto userdto) {
		Connection con = null;
		PreparedStatement stmt = null;

		System.out.println(userdto.getname());

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/jsa04","pma","Centosadmin1!");
			stmt = con.prepareStatement("UPDATE user SET mail=?,pass = ?,name = ? WHERE userId = ?");


			stmt.setString(1, userdto.getmail());
			stmt.setString(2, userdto.getpass());
			stmt.setString(3, userdto.getname());
			stmt.setInt(4,userdto.getuserId());

			stmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if( stmt != null ) {stmt.close();}
				if( stmt != null ) {con.close(); }
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

	public void delete(int userid) {
		Connection con = null;
		PreparedStatement stmt = null;

		try{
			//データベースの接続
			Class.forName("com.mysql.jdbc.Driver");

			//*******
			con = DriverManager.getConnection("jdbc:mysql://localhost/jsa04","pma","Centosadmin1!");

			//*******
			stmt = con.prepareStatement("DELETE FROM user WHERE userId=?");

			stmt.setInt(1, userid);

			//SQLを発行して、ユーザーテーブルからデ9ータ取得
			stmt.executeUpdate();


		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(stmt != null){stmt.close();}
				if(con != null){con.close();}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public UserDto getUserByID(String mail) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}


}
