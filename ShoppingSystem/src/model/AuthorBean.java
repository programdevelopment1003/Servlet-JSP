package model;

import java.io.Serializable;

public class AuthorBean implements Serializable {
	
	private int a_id;
	private String a_name;

	public AuthorBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getA_name() {
		return a_name;
	}

	public void setA_name(String a_name) {
		this.a_name = a_name;
	}

}
