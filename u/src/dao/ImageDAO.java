package dao;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ImageDAO extends DaoBase {
	public BufferedImage getPicture(int id){
		System.out.println("ああああ");

		try{
		   super.DbOpen();
		   String sql  ="select * from imag where imgId = ?";
		   stmt = con.prepareStatement(sql);
		   stmt.setInt(1, id);
		   rs = stmt.executeQuery();
		   rs.next();
		   InputStream is = rs.getBinaryStream("ima");
		   BufferedInputStream bis = new BufferedInputStream(is);

		   return ImageIO.read(bis);

		}catch(Exception e){
			System.out.println(e);
		}finally {
		   try{
		    super.DbClose();
		   }catch(Exception e){
		    System.out.println("error");
		   }
		}
		  return null;
	}

}
