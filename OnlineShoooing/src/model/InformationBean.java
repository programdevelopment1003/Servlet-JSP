package model;

public class InformationBean {
	private int id;
	private String username;
	private String authority;

	public InformationBean() {}

	public InformationBean(int id,String username,String authority){
		this.id=id;
		this.username=username;
		this.authority=authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
