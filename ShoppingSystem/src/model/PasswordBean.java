package model;

import java.io.Serializable;

public class PasswordBean implements Serializable {
	
	private String m_add;
	private String password;
	
	public PasswordBean(){
		
	}
	
	public PasswordBean(String id,String pass) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.m_add = id;
		this.password = pass;
	}

	public String getM_add() {
		return m_add;
	}

	public void setM_add(String m_add) {
		this.m_add = m_add;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}