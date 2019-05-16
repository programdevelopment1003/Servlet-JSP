package dao;

import java.util.ArrayList;

import model.DetailBean;

public class ContDetailDao extends DaoBase{
	ArrayList<DetailBean> dlist = new ArrayList<DetailBean>();

	public ArrayList<DetailBean> getCont(int contId) {
		try {
			//connection確立
	        super.DbOpen();
	        //where end > 日付で指定した方がいいかも
	        String sql = "select * from detail where contId="+contId;
	        stmt = con.prepareStatement(sql);
            rs= stmt.executeQuery();

            while(rs.next()){
            		//UserBeanへ値を格納
            		DetailBean dbean = new DetailBean();
            		dbean.setContId(rs.getInt("contId"));
            		dbean.setDetailId(rs.getInt("detailId"));
            		dbean.setImaId(rs.getInt("imaId"));
            		dbean.setVote(rs.getInt("vote"));

            		dlist.add(dbean);
            }
            System.out.println("detaildao4"+dlist.get(0));
			}catch (Exception e){
				e.printStackTrace();
			}finally{
				try{
					super.DbClose();
				} catch(Exception e){
					System.out.println("error");
				}
			}
		 return dlist;
	}
	//contentの追加
	public void setCont(String contName,int end,String note) {
		try {
			//connection確立
	        super.DbOpen();

	        String sql = "INSERT INTO `CONTENT`(`contName`, `end`, `delete`, `note`) VALUES (?,?,1,?)";
	        stmt = con.prepareStatement(sql);
	        stmt.setString(1,contName);
	        stmt.setInt(2,end);
	        stmt.setString(3,note);
	        rsno= stmt.executeUpdate();

			}catch (Exception e){
				e.printStackTrace();
			}finally{
				try{
					super.DbClose();
				} catch(Exception e){
					System.out.println("error");
				}
			}
	}

	//detailの変更
	public void update(int contId,int detailId,int vote,int imageId,String note2){

		//connection確立
		super.DbOpen();
        try {
        		String sql = "update `CONTENT` SET  (detailId,vote,imageId,note2)、(?,?,?,?) WHERE contId = ?";

        		stmt = con.prepareStatement(sql);

    	        stmt.setInt(1,detailId);
    	        stmt.setInt(2, vote);
    	        stmt.setInt(3,imageId);
    	        stmt.setString(4,note2);
    	        stmt.setInt(5,contId);
            stmt.executeUpdate();

    }catch (Exception e){
        e.printStackTrace();
    }finally{
        try{
            super.DbClose();
        } catch(Exception e){
            System.out.println("error");
        }
    }

	}
	//投票
		public int Vote(int contId , int detailId) {
			int vote =0;
			//connection確立
				super.DbOpen();
			    try {
			    	 String sql = "select * from detail where contId=? and detailId =?";

			    	 stmt = con.prepareStatement(sql);
			    	 stmt.setInt(1,contId);
		    	     stmt.setInt(2,detailId);
			     rs= stmt.executeQuery();

	             rs.next();
	             vote =rs.getInt("vote");

			    }catch (Exception e){
					e.printStackTrace();
				}finally{
					try{
						super.DbClose();
					} catch(Exception e){
						System.out.println("error");
					}
				}
			    return vote;
		}
		public void setVote(int contId,int detailId ,int vote) {
			//connection確立
				super.DbOpen();
			    try {
			    		String sql = "UPDATE `content` SET vote=? WHERE contId =? and detailId =? ";

			        	stmt = con.prepareStatement(sql);
			        	stmt.setInt(1,vote);
			        	stmt.setInt(2,contId);
			    	     stmt.setInt(3,detailId);
			         stmt.executeUpdate();

			    }catch (Exception e){
			        e.printStackTrace();
			    }finally{
			        try{
			            super.DbClose();
			        } catch(Exception e){
			            System.out.println("error");
			        }
			    }
		}


	//detailの削除
	public void delete(int contId){

		//connection確立
		super.DbOpen();
        try {
        		String sql = "delete from `CONTENT` WHERE contId = "+contId;

        		stmt = con.prepareStatement(sql);
            rs= stmt.executeQuery();


    }catch (Exception e){
        e.printStackTrace();
    }finally{
        try{
            super.DbClose();
        } catch(Exception e){
            System.out.println("error");
        }
    }

	}

}
