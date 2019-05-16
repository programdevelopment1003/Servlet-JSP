package model;

import java.io.Serializable;

public class GenreBean implements Serializable {
	
	private int g_id;
	private String g_name;

	public GenreBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

}
