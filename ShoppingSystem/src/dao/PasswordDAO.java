package dao;

import model.PasswordBean;
import model.UserBean;

public class PasswordDAO extends DaoBase {

	public PasswordBean searchUser(String id,String pass) {
		
		try{
		PasswordBean userpass = new PasswordBean();
		super.connection();
		
		String sql ="select m_add,password from password where m_add = ? and password = ?";
		stmt = con.prepareStatement(sql);
		
		stmt.setString(1, id);
		stmt.setString(2, pass);
		rs=stmt.executeQuery();
		rs.next();
		
		userpass.setM_add(rs.getString(1));
		userpass.setPassword(rs.getString(2));
		return userpass;
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		return null;
		//ユーザが見つかれば該当ユーザ情報を、いなければnullをかえす
	}
	
	public void PasswordInsert(PasswordBean userpass) {
		
		try{
			super.connection();
		
			super.connection();
			String sql  ="insert into password values(?,?)";
			
			stmt = con.prepareStatement(sql);
			String id = userpass.getM_add();
			String pcode = userpass.getPassword();
			
			stmt.setString(1, id);
			stmt.setString(2, pcode);
			
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
	
	public void passDelete(String id){
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="Delete from password where m_add = ?";
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
	
	public PasswordBean getPassword(String id) {
		
		try{
		PasswordBean userpass = new PasswordBean();
		super.connection();
		
		String sql ="select * from password where m_add = ?";
		stmt = con.prepareStatement(sql);
		
		stmt.setString(1, id);
		rs=stmt.executeQuery();
		rs.next();
		
		userpass.setM_add(rs.getString(1));
		userpass.setPassword(rs.getString(2));
		return userpass;
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
	
	public void passUpdate(String id,String pass){
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="Update password set password=? where m_add = ?";
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1,pass);
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
	public void passUpdate2(String id,String newid,String pass){
		try{
			//super.DbOpen();
			super.connection();
			
			String sql ="Update password set m_add=?,password=? where m_add = ?";
			stmt = con.prepareStatement(sql);
			
			stmt.setString(1,newid);
			stmt.setString(2,pass);
			stmt.setString(3,id);
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
