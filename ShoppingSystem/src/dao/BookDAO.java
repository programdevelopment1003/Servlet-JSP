package dao;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import model.BookBean;
import model.CartBean;
import model.UserBean;

public class BookDAO extends DaoBase {

	public BookDAO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public ArrayList<BookBean> getAllbook(){
		ArrayList<BookBean> arraybook = new ArrayList<BookBean>();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from book";
			stmt = con.prepareStatement(sql);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				BookBean bookbean = new BookBean();
				
				bookbean.setB_id(rs.getInt("b_id"));
				bookbean.setB_name(rs.getString("b_name"));
				bookbean.setB_namey(rs.getString("b_namey"));
				bookbean.setPrice(rs.getInt("price"));
				bookbean.setA_id(rs.getInt("a_id"));
				bookbean.setG_id(rs.getInt("g_id"));
				bookbean.setStock(rs.getInt("stock"));
				bookbean.setPicture(rs.getBlob("picture"));
				
				arraybook.add(bookbean);
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
		return arraybook;
	}
	
	public ArrayList<BookBean> getKyewordBook(String word){
		ArrayList<BookBean> arraybook = new ArrayList<BookBean>();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from book where b_namey like ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+word+"%");
			rs=stmt.executeQuery();
			
			while(rs.next()){
				BookBean bookbean = new BookBean();
				
				bookbean.setB_id(rs.getInt("b_id"));
				bookbean.setB_name(rs.getString("b_name"));
				bookbean.setB_namey(rs.getString("b_namey"));
				bookbean.setPrice(rs.getInt("price"));
				bookbean.setA_id(rs.getInt("a_id"));
				bookbean.setG_id(rs.getInt("g_id"));
				bookbean.setStock(rs.getInt("stock"));
				bookbean.setPicture(rs.getBlob("picture"));
				
				arraybook.add(bookbean);
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
		return arraybook;
	}
	
	public ArrayList<BookBean> getGenreBook(int id){
		ArrayList<BookBean> arraybook = new ArrayList<BookBean>();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from book where g_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				BookBean bookbean = new BookBean();
				
				bookbean.setB_id(rs.getInt("b_id"));
				bookbean.setB_name(rs.getString("b_name"));
				bookbean.setB_namey(rs.getString("b_namey"));
				bookbean.setPrice(rs.getInt("price"));
				bookbean.setA_id(rs.getInt("a_id"));
				bookbean.setG_id(rs.getInt("g_id"));
				bookbean.setStock(rs.getInt("stock"));
				bookbean.setPicture(rs.getBlob("picture"));
				
				arraybook.add(bookbean);
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
		return arraybook;
	}
	
	public ArrayList<BookBean> getAuthorBook(int id){
		ArrayList<BookBean> arraybook = new ArrayList<BookBean>();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from book where a_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				BookBean bookbean = new BookBean();
				
				bookbean.setB_id(rs.getInt("b_id"));
				bookbean.setB_name(rs.getString("b_name"));
				bookbean.setB_namey(rs.getString("b_namey"));
				bookbean.setPrice(rs.getInt("price"));
				bookbean.setA_id(rs.getInt("a_id"));
				bookbean.setG_id(rs.getInt("g_id"));
				bookbean.setStock(rs.getInt("stock"));
				bookbean.setPicture(rs.getBlob("picture"));
				
				arraybook.add(bookbean);
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
		return arraybook;
	}
	
	public BookBean getBooks(int id){
		BookBean bookbean = new BookBean();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from book where b_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			
			rs.next();
			
			bookbean.setB_id(rs.getInt("b_id"));
			bookbean.setB_name(rs.getString("b_name"));
			bookbean.setB_namey(rs.getString("b_namey"));
			bookbean.setPrice(rs.getInt("price"));
			bookbean.setA_id(rs.getInt("a_id"));
			bookbean.setG_id(rs.getInt("g_id"));
			bookbean.setStock(rs.getInt("stock"));
			bookbean.setPicture(rs.getBlob("picture"));
				
			
		}catch(Exception e){
			//bookbean=null;
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return bookbean;
	}
	
	public void BookStock(ArrayList<BookBean> books){
		try{
			super.connection();
			for(BookBean book:books){
				String sql ="Update book set stock = ? where b_id = ?";
				stmt = con.prepareStatement(sql);
				
				stmt.setInt(1, book.getStock());
				stmt.setInt(2, book.getB_id());
				rsno=stmt.executeUpdate();
			}
			}catch(Exception e){
				System.out.println("error");
			}finally {
				try{
					super.DbClose();
				}catch(Exception e){
					System.out.println("error");
				}
			}
	}
	public void BookInsert(String b_name,String b_namey,int price,int a_id,int g_id,int stock,InputStream picture){
		//渡されたユーザ情報をユーザテーブルへ挿入
		try{
			//super.DbOpen();
			super.connection();
			String sql  ="insert into book(b_name,b_namey,price,a_id,g_id,stock,picture) values(?,?,?,?,?,?,?)";
			
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, b_name);
			stmt.setString(2, b_namey);
			stmt.setInt(3, price);
			stmt.setInt(4, a_id);
			stmt.setInt(5, g_id);
			stmt.setInt(6, stock);
			stmt.setBlob(7, picture);
			
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
	public int BookLast(){
	
	int lastid = 0;
		try{
			//super.DbOpen();
			super.connection();
			String sql  ="select b_id from book";
			
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
	public BufferedImage getPicture(int id){
		try{
		   super.connection();
		   String sql  ="select * from book where b_id = ?";
		   stmt = con.prepareStatement(sql); 
		   stmt.setInt(1, id);
		   rs = stmt.executeQuery();
		   rs.next();
		   InputStream is = rs.getBinaryStream("picture");
		   BufferedInputStream bis = new BufferedInputStream(is);
		   return ImageIO.read(bis);

		}catch(Exception e){

		}finally {
		   try{
		    super.DbClose();
		   }catch(Exception e){
		    System.out.println("error");
		   }
		} 
		  return null;
	}
	
	public void bookUpdate(int id,int price,int stock){
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="Update book set price=?,stock=? where b_id = ?";
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1,price);
			stmt.setInt(2,stock);
			stmt.setInt(3,id);
			
			rsno=stmt.executeUpdate();
			
			}catch(Exception e){
				
			}finally {
				try{
					super.DbClose();
				}catch(Exception e){
					System.out.println("error");
				}
			}
	}
	
	public void bookDelete(int id){
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="Delete from book where b_id = ?";
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1,id);
			rsno=stmt.executeUpdate();
			
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
