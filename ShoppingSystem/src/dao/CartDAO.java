package dao;

import java.util.ArrayList;

import model.BookBean;
import model.CartBean;

public class CartDAO extends DaoBase {

	public CartDAO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public void CartInsert(String m_add,int b_id){
		try{
			//super.DbOpen();
			super.connection();
			String sql  ="insert into cart(m_add,b_id,suryo) values(?,?,1)";
			
			stmt = con.prepareStatement(sql);		
			stmt.setString(1, m_add);
			stmt.setInt(2, b_id);
			
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
	
	public ArrayList<CartBean> getCart(String id){
		ArrayList<CartBean> arraycart = new ArrayList<CartBean>();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from cart where m_add = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				CartBean cartbean = new CartBean();
				
				cartbean.setC_id(rs.getInt("c_id"));
				cartbean.setM_add(rs.getString("m_add"));
				cartbean.setB_id(rs.getInt("b_id"));
				cartbean.setSuryo(rs.getInt("suryo"));
				
				arraycart.add(cartbean);
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
		return arraycart;
	}
	
	public void cartDelete(int id){
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="Delete from cart where c_id = ?";
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
	
	public void cartSettlement(String id){
		try{
			super.connection();
				String sql ="Delete from cart where m_add = ?";
				stmt = con.prepareStatement(sql);
				
				stmt.setString(1,id);
				rsno=stmt.executeUpdate();
				
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
	public CartBean CartSearch(String u_id,int b_id){
		
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from cart where m_add = ? && b_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, u_id);
			stmt.setInt(2, b_id);
			rs=stmt.executeQuery();
			
			CartBean cartbean = new CartBean();
			rs.next();
			cartbean.setC_id(rs.getInt("c_id"));
			cartbean.setM_add(rs.getString("m_add"));
			cartbean.setB_id(rs.getInt("b_id"));
			cartbean.setSuryo(rs.getInt("suryo"));
				
			return cartbean;
		}catch(Exception e){
			//bookbean=null;
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return null;
	}
	public void CartSuryoadd(CartBean cart){
		try{
			super.connection();
			
			String sql ="Update cart set suryo = suryo+1 where c_id = ? ";
			stmt = con.prepareStatement(sql);
				
			stmt.setInt(1, cart.getC_id());
			rsno=stmt.executeUpdate();
			
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

}
