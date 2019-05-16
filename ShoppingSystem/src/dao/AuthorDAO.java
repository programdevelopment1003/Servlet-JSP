package dao;

import java.util.ArrayList;

import model.AuthorBean;
import model.GenreBean;
import model.UserBean;

public class AuthorDAO extends DaoBase {

	public AuthorDAO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public ArrayList<AuthorBean> getAllauthor(){
		ArrayList<AuthorBean> arrayauthor = new ArrayList<AuthorBean>();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from author";
			stmt = con.prepareStatement(sql);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				AuthorBean authorbean = new AuthorBean();
				
				authorbean.setA_id(rs.getInt("a_id"));
				authorbean.setA_name(rs.getString("a_name"));
				
				arrayauthor.add(authorbean);
			}
			
		}catch(Exception e){
			//bookbean=null;
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return arrayauthor;
	}
	public int AuthorLast(){
		
		int lastid = 0;
		try{
			//super.DbOpen();
			super.connection();
			String sql  ="select a_id from author";
				
			stmt = con.prepareStatement(sql);
			rs=stmt.executeQuery();
			
			while(rs.next()){
					lastid = rs.getInt(1);
			}	
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return lastid;
	}
	public void AuthorInsert(String a_name){
		//渡されたユーザ情報をユーザテーブルへ挿入
		try{
			//super.DbOpen();
			super.connection();
			String sql  ="insert into author(a_name) values(?)";
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, a_name);
			
			rsno = stmt.executeUpdate();
				
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
	}
}
