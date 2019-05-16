package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class SQL {
	Connection con=null;	//DBMSへの接続や切断を行う
	PreparedStatement stmt = null;	//SQLの送信を行う
	ResultSet rs=null;		//DBMSからの検索結果を受け取る
	int rsno=0;				//DBMSからの処理件数を受け取る

	//データソース

	DataSource ds = null;

	public SQL() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Connection DbOpen(){
		//JDBCドライバのロード(java6から(現在は)省略可)
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//指定するデータベースへ接続(引数:URL/利用ユーザ/パスワード)
			con=DriverManager.getConnection(
					"jdbc:mysql://localhost/jsa04", "pma", "Centosadmin1!");

		} catch (ClassNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return con;
	}

	/**
	 * データベースへの接続処理を行うメソッド
	 * @return コネクション情報
	 */


	public void DbClose(){
	    //接続したものが空でなければ閉じる
		try {
  		if(rs != null){rs.close();}
		    if(stmt != null){stmt.close();}
		    if(con != null){con.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
