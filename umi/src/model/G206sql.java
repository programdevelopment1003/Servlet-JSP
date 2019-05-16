
package model;

import java.io.InputStream;

public class G206sql extends SQL {
	public G206sql(){}

	public void setimg(String name, InputStream is) {

		try{
			System.out.println("starat!!!");
			super.DbOpen();
			String imag = "insert into imag(name,img) values(?,?)";
			stmt=con.prepareStatement(imag);
			stmt.setString(1,name);
			stmt.setBlob(2,is);
			stmt.executeUpdate();
		}catch(Exception e){
			System.out.println(e+"sss");
			System.out.println("1111");
			e.printStackTrace();
			System.out.println("1111");
		}finally{
			try{
				if(stmt !=null){stmt.close();}
				if(con !=null){con.close();}
			}catch(Exception e){
				System.out.println(e+"sss");
				System.out.println("111123443");
			}
		}
	}
public void  setDetails(String Des,String name,int contId) {
	try{
	super.DbOpen();
	System.out.println("11");
	String getimag = "select imgId from imag where name=?";
	System.out.println("22");
	stmt=con.prepareStatement(getimag);
	System.out.println("33");
	stmt.setString(1,name);
	System.out.println("4");
	rs=stmt.executeQuery();
	int imgId =0;
	while(rs.next()){
	 imgId = rs.getInt("imgId");
		System.out.println(imgId);
		System.out.println("sl");
	}

	String content ="insert into detail(contId,imgId,vote,note2) values(?,?,?,?)";
	stmt=con.prepareStatement(content);
	stmt.setInt(1,contId);
	stmt.setInt(2,imgId);
	stmt.setInt(3,0);
	stmt.setString(4,Des);
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

