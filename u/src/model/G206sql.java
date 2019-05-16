
package model;

import java.io.InputStream;

public class G206sql extends SQL {
	public G206sql(){}

	public void setimg(String name, InputStream is) {

		try{
			super.DbOpen();
			String imag = "insert into imag(name,ima) values(?,?)";
			stmt=con.prepareStatement(imag);
			stmt.setString(1,name);
			stmt.setBlob(2,is);
			stmt.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}finally{
			try{
				if(stmt !=null){stmt.close();}
				if(con !=null){con.close();}
			}catch(Exception e){
				System.out.println(e);
			}
		}
	}
public void  setDetails(String Des,String name,int contId) {
	try{
	super.DbOpen();
	String getimag = "select imgId from imag where name=?";
	stmt=con.prepareStatement(getimag);
	stmt.setString(1,name);
	rs=stmt.executeQuery();
	int imgId =0;
	while(rs.next()){
	 imgId = rs.getInt("imgId");
	}

	String content ="insert into detail(contId,imaId,vote) values(?,?,?)";
	stmt=con.prepareStatement(content);
	stmt.setInt(1,contId);
	stmt.setInt(2,imgId);
	stmt.setInt(3,0);
	stmt.execute();
}catch(Exception e){
	System.out.println(e);

}finally{
	try{
	}catch(Exception e){
		System.out.println(e);

	}
}

}
}

