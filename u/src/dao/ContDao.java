package dao;

import java.util.ArrayList;

import model.ContBean;

public class ContDao extends DaoBase {

	ArrayList<ContBean> clist = new ArrayList<ContBean>();

	public ArrayList<ContBean> getCont() {
		try {
			//connection確立
	        super.DbOpen();
	        //where end > 日付で指定した方がいいかも
	        String sql = "select * from content";

	        stmt = con.prepareStatement(sql);
            rs= stmt.executeQuery();

            while(rs.next()){
            		//contBeanへ値を格納
             	ContBean cbean = new ContBean();
          System.out.println("*********cdao"+rs.getInt("contId"));
            	    cbean.setContId(rs.getInt("contId"));
            		cbean.setContName(rs.getString("contName"));
            		cbean.setStart(rs.getString("start"));
            		cbean.setEnd(rs.getString("end"));
            		cbean.setNote(rs.getString("note"));
            		cbean.setImageId(rs.getInt("imagId"));
            		clist.add(cbean);
            		
            }
           

            }catch (Exception e){
				e.printStackTrace();
			}finally{
				try{
					super.DbClose();
				} catch(Exception e){
					System.out.println("error");
				}
			}
		 return clist;
	}
	//contentの追加
//	public void setCont(String contName,int end,String note,String image) {
//		try {
//			//connection確立
//	        super.DbOpen();
//
//	        String sql = "INSERT INTO `CONTENT`(`contName`, `end`, `note`,`image`) VALUES (?,?,?,?)";
//	        stmt = con.prepareStatement(sql);
//	        stmt.setString(1,contName);
//	        stmt.setInt(2,end);
//	        stmt.setString(3,note);
//	        rsno= stmt.executeUpdate();
//
//			}catch (Exception e){
//				e.printStackTrace();
//			}finally{
//				try{
//					super.DBClose();
//				} catch(Exception e){
//					System.out.println("error");
//				}
//			}
//	}

	//contentの変更
	public void update(int contId,String contName,String start,String end,String note,int imagId){
		System.out.println("*contUPdate");
		//connection確立
		super.DbOpen();
        try {

        	System.out.println("*up sql");
        		String sql = "UPDATE `content` SET contName=?,end=?,note=?,start=?,imagId=? WHERE contId = ?";
System.out.println("*contDaoupdate");
        		stmt = con.prepareStatement(sql);

    	        stmt.setString(1,contName);
    	        stmt.setString(2,start);
    	        stmt.setString(3,end);
    	        stmt.setString(4,note);
    	        stmt.setInt(5,imagId);
    	        stmt.setInt(6,contId);
    	        System.out.println("*contUPdate");

    	        stmt.executeUpdate();

    	    System.out.println("*cdao.change");
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


	//contentの削除
	/*
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
            super.DBClose();
        } catch(Exception e){
            System.out.println("error");
        }
    }

	} */
}
