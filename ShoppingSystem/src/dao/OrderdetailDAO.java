package dao;

import java.util.ArrayList;

import model.BookBean;
import model.CartBean;
import model.OrderBean;
import model.OrderdetailBean;

public class OrderdetailDAO extends DaoBase {

	public OrderdetailDAO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void detailInsert(int lastid,ArrayList<CartBean> arraycart,ArrayList<BookBean> arraybook){
		//渡されたユーザ情報をユーザテーブルへ挿入
		int count = 0;
		try{
			//super.DbOpen();
			super.connection();
			
			for(BookBean book:arraybook){
				CartBean cartbean = new CartBean();
				cartbean = arraycart.get(count);
				String sql  ="insert into order_detail values(?,?,?,?)";
			
				stmt = con.prepareStatement(sql);
			
				stmt.setInt(1, lastid);
				stmt.setInt(2, book.getB_id());
				stmt.setInt(3, cartbean.getSuryo());
				stmt.setInt(4, book.getPrice());
			
				rsno = stmt.executeUpdate();
				count++;
			}
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
	}
	public ArrayList<OrderdetailBean> getOrderdetail(int id){
		ArrayList<OrderdetailBean> arrayorderdetail = new ArrayList<OrderdetailBean>();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from order_detail where o_code = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				OrderdetailBean orderbean = new OrderdetailBean();
				
				orderbean.setO_code(rs.getInt("o_code"));
				orderbean.setB_id(rs.getInt("b_id"));
				orderbean.setSuryo(rs.getInt("suryo"));
				orderbean.setPrice(rs.getInt("price"));
				
				arrayorderdetail.add(orderbean);
			}
			
			return arrayorderdetail;
			
		}catch(Exception e){
			System.out.println("error1");
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error2");
			}
		}
		System.out.println("error3");
		return null;
	}

}
