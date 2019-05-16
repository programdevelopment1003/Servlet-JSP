package dao;

import java.util.ArrayList;

import model.BookBean;
import model.UserBean;

public class UserDAO extends DaoBase {
	
	public UserBean getUser(String id){
		UserBean user = new UserBean();
		try{
		super.connection();
		
		String sql ="select m_add,p_code,s_add,t_code,name,name_y,authority from users where m_add = ?";
		stmt = con.prepareStatement(sql);
		
		stmt.setString(1, id);
		rs=stmt.executeQuery();
		rs.next();
		
		user.setM_add(rs.getString(1));
		user.setP_code(rs.getInt(2));
		user.setS_add(rs.getString(3));
		user.setT_code(rs.getString(4));
		user.setName(rs.getString(5));
		user.setName_y(rs.getString(6));
		user.setAuthority(rs.getString(7));
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return user;
		//ユーザが見つかれば該当ユーザ情報を、いなければnullをかえす
	}
	
	public void Userinsert(UserBean user){
		//渡されたユーザ情報をユーザテーブルへ挿入
		try{
			//super.DbOpen();
			super.connection();
			String sql  ="insert into users(m_add,p_code,s_add,t_code,name,name_y) values(?,?,?,?,?,?)";
			
			stmt = con.prepareStatement(sql);
			String id = user.getM_add();
			int pcode = user.getP_code();
			String sadd = user.getS_add();
			String tcode = user.getT_code();
			String name = user.getName();
			String namey = user.getName_y();
			
			stmt.setString(1, id);
			stmt.setInt(2, pcode);
			stmt.setString(3, sadd);
			stmt.setString(4, tcode);
			stmt.setString(5, name);
			stmt.setString(6, namey);
			
			rsno = stmt.executeUpdate();
				
		}catch(Exception e){
			user=null;
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
	}
	
	public String CheckUser(String id){
		try{
			super.connection();
		
			String sql ="select m_add from users where m_add = ?";
			stmt = con.prepareStatement(sql);
		
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			rs.next();
		
			String id2 = rs.getString(1);
			return id2;
		}catch(Exception e){
			
		}finally{
			try{
				super.DbClose();
			}catch(Exception e){
				
			}
		}
		return "";
	}
	
	public void userDelete(String id){
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="Delete from users where m_add = ?";
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1,id);
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
	
	public void userUpdate(String id,int p_code,String s_add,String t_code,String name,String name_y){
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="Update users set p_code=?,s_add=?,t_code=?,name=?,name_y=? where m_add = ?";
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1,p_code);
			stmt.setString(2,s_add);
			stmt.setString(3,t_code);
			stmt.setString(4,name);
			stmt.setString(5,name_y);
			stmt.setString(6,id);
			
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
	
	public ArrayList<UserBean> getAlluser(){
		ArrayList<UserBean> arrayuser = new ArrayList<UserBean>();
		try{
			//super.DbOpen();
			super.connection();
			
			String sql  ="select * from users";
			stmt = con.prepareStatement(sql);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				UserBean userbean = new UserBean();
				
				userbean.setM_add(rs.getString("m_add"));
				userbean.setName(rs.getString("name"));
				userbean.setName_y(rs.getString("name_y"));
				userbean.setP_code(rs.getInt("p_code"));
				userbean.setS_add(rs.getString("s_add"));
				userbean.setT_code(rs.getString("t_code"));
				userbean.setAuthority(rs.getString("authority"));
				
				arrayuser.add(userbean);
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
		return arrayuser;
	}
	public void userUpdate2(String id,String newid,int p_code,String s_add,String t_code,String name,String name_y){
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="Update users set m_add=?,p_code=?,s_add=?,t_code=?,name=?,name_y=? where m_add = ?";
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1,newid);
			stmt.setInt(2,p_code);
			stmt.setString(3,s_add);
			stmt.setString(4,t_code);
			stmt.setString(5,name);
			stmt.setString(6,name_y);
			stmt.setString(7,id);
			
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
	
	public void userAuthUpdate(String id,String auth){
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="Update users set authority=? where m_add = ?";
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1,auth);
			stmt.setString(2,id);
			
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
