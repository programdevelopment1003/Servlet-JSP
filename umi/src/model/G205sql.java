package model;

import java.io.InputStream;
import java.sql.Date;

public class G205sql extends SQL{
	public G205sql() {}

	public int content(String name, String end, String Descripion, String stat,InputStream is) {
		int contId =0;
		try{
			System.out.println("1");
		super.DbOpen();
		Date endDate =Date.valueOf(end);
		Date statDate = Date.valueOf(stat);
		System.out.println("1");

		String getimag = "select imgId from imag where name=?";
		System.out.println("2");

		stmt=con.prepareStatement(getimag);
		System.out.println("3");

		stmt.setString(1,name);
		System.out.println("422");

		rs=stmt.executeQuery();
		int imgId =0;
		while(rs.next()){
		 imgId = rs.getInt("imgId");
			System.out.println(imgId);


		}

		String content ="insert into content(contName,end,deleate,note,start,imgId) values(?,?,?,?,?,?)";
		stmt=con.prepareStatement(content);
		stmt.setString(1,name);
		stmt.setDate(2,endDate);
		stmt.setString(3,"1");
		stmt.setString(4,Descripion);
		stmt.setDate(5,statDate);
		stmt.setInt(6,imgId);
		stmt.execute();

		String contentId = "select contId from content where imgId=?";
		stmt=con.prepareStatement(contentId);
		stmt.setInt(1,imgId);
		rs=stmt.executeQuery();

		while(rs.next()){
			 contId= rs.getInt("contId");
			}





	}catch(Exception e){
		System.out.println(e);

	}finally{
		try{
		}catch(Exception e){
			System.out.println(e);

		}
	}
		return contId;
	}
	public void setimg(String name, InputStream is) {
		try{
			super.DbOpen();
			String imag = "insert into imag(name,img) values(?,?)";
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

}
