package dao;

import java.io.InputStream;

import javax.sql.DataSource;

public class BlobDao extends DaoBase{
	//データソース
		DataSource ds=null;
		public void boleSQLcha(int imageId, InputStream is) {
			try{
				//connection確率
				super.DbOpen();
//				Context context = new InitialContext();
				String sql = "update `imag` set  img=? WHERE imgId = "+imageId;
				stmt=con.prepareStatement(sql);
				stmt.setBlob(1,is);
				rsno=stmt.executeUpdate();

			}catch(Exception e){
				System.out.println(e);
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