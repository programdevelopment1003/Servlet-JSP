package model;

import java.io.Serializable;

public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String m_add;
	private int p_code;
	private String s_add;
	private String t_code;
	private String name;
	private String name_y;
	private String authority;

	public UserBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public UserBean(String m_add,int p_code, String s_add,String t_code, String name,String name_y) {
		super();
		this.m_add = m_add;
		this.p_code = p_code;
		this.s_add = s_add;
		this.t_code = t_code;
		this.name = name;
		this.name_y = name_y;
	}

	public String getM_add() {
		return m_add;
	}

	public void setM_add(String m_add) {
		this.m_add = m_add;
	}

	public int getP_code() {
		return p_code;
	}

	public void setP_code(int p_code) {
		this.p_code = p_code;
	}

	public String getS_add() {
		return s_add;
	}

	public void setS_add(String s_add) {
		this.s_add = s_add;
	}

	public String getT_code() {
		return t_code;
	}

	public void setT_code(String t_code) {
		this.t_code = t_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_y() {
		return name_y;
	}

	public void setName_y(String name_y) {
		this.name_y = name_y;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
