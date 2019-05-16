package dto;

public class UserDto {

	private int userId;
	private String pass;
	private String name;
	private String mail;
	private String authority;

	public int getuserId() {
		return userId;
	}
	public void setuserId(int i) {
		this.userId = i;
	}
	public String getpass() {
		return pass;
	}
	public void setpass(String pass) {
		this.pass = pass;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		System.out.println(name);
		this.name = name;
	}
	public String getmail() {
		return mail;
	}
	public void setmail(String mail) {
		this.mail = mail;
	}
	public String getauthority() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
