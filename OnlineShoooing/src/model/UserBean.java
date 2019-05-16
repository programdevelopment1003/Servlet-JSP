package model;

public class UserBean {
	private String username;
	private String mail;
	private String password;
	private String name;
	private String post;
	private String address;

	public UserBean(){

	}

	public UserBean(String username,String mail,String password,String name,String post,String address){
		this.username=username;
		this.mail=mail;
		this.password=password;
		this.name=name;
		this.post=post;
		this.address=address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
