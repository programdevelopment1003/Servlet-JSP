package model;

public class VoteSQL extends SQL{
	public VoteSQL() {}

	public int getvote(int detailId) {
		try {
			super.DbOpen();
			String getimag = "select vote from detail where detailId = ?";
			stmt=con.prepareStatement(getimag);
			stmt.setInt(1,detailId);
			rs=stmt.executeQuery();
			rs.next();
			return rs.getInt("vote");		
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
		return 0;
	}

	public boolean setvote(int vote,int detailId) {
		boolean Boolean = false;
		try {
			super.DbOpen();
			String getimag = "UPDATE detail SET vote = ? WHERE detailId = ?";
			stmt=con.prepareStatement(getimag);
			stmt.setInt(1,vote);
			stmt.setInt(2,detailId);
			stmt.execute();
			Boolean = true;
		}catch(Exception e){
			System.out.println(e);

		}finally{
			try{
			}catch(Exception e){
				System.out.println(e);

			}
		}
		return Boolean;
	}

	public void sethistory(int userId,int contId) {
		try {
			super.DbOpen();
			String sethistory = "insert into vote(userId,contId) values(?,?)";
			stmt=con.prepareStatement(sethistory);
			stmt.setInt(1,userId);
			stmt.setInt(2,contId);
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
