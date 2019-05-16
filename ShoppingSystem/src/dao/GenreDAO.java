package dao;

import java.util.ArrayList;

import model.BookBean;
import model.GenreBean;

public class GenreDAO extends DaoBase {

	public GenreDAO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public ArrayList<GenreBean> getAllgenre(){
		ArrayList<GenreBean> arraygenre = new ArrayList<GenreBean>();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from genre";
			stmt = con.prepareStatement(sql);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				GenreBean genrebean = new GenreBean();
				
				genrebean.setG_id(rs.getInt("g_id"));
				genrebean.setG_name(rs.getString("g_name"));
				
				arraygenre.add(genrebean);
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
		return arraygenre;
	}
	
	public int GenreLast(){
		
		int lastid = 0;
		try{
			//super.DbOpen();
			super.connection();
			String sql  ="select g_id from genre";
				
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
	
	public void GenreInsert(String g_name){
		
		try{
			//super.DbOpen();
			super.connection();
			String sql  ="insert into genre(g_name) values(?)";
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, g_name);
			
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
