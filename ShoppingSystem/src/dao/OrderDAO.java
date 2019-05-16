package dao;

import java.util.ArrayList;

import model.BookBean;
import model.CartBean;
import model.OrderBean;
import model.UserBean;

public class OrderDAO extends DaoBase {

	public OrderDAO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public void Orderinsert(String id,int price){
		//渡されたユーザ情報をユーザテーブルへ挿入
		try{
			//super.DbOpen();
			super.connection();
			String sql  ="insert into userorder(m_add,t_price) values(?,?)";
			
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, id);
			stmt.setInt(2, price);
			
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
	public int getlastOrderid(){
		int lastid = 0;
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from userorder";
			stmt = con.prepareStatement(sql);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				
				lastid = rs.getInt("o_code");
				
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
		return lastid;
	}
	public ArrayList<OrderBean> getOrder(String id){
		ArrayList<OrderBean> arrayorder = new ArrayList<OrderBean>();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from userorder where m_add = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				OrderBean orderbean = new OrderBean();
				
				orderbean.setO_code(rs.getInt("o_code"));
				orderbean.setM_add(rs.getString("m_add"));
				orderbean.setDay(rs.getDate("day"));
				orderbean.setT_price(rs.getInt("t_price"));
				
				arrayorder.add(orderbean);
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
		return arrayorder;
	}

}
