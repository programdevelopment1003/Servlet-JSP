package model;

public class VoteDTO {
	private int userId;
	private int contId;
	private int detailId;
	
	public VoteDTO() {}
	
	public void votedto(int userId,int contId,int detailId) {
		this.userId = userId;
		this.contId = contId;
		this.detailId = detailId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getContId() {
		return contId;
	}

	public void setContId(int contId) {
		this.contId = contId;
	}

	public int getDetailId() {
		return detailId;
	}

	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	

}
