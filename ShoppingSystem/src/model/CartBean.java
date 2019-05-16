package model;

import java.io.Serializable;

public class CartBean implements Serializable {
	private int c_id;
	private String m_add;
	private int b_id;
	private int suryo;
	
	public CartBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getM_add() {
		return m_add;
	}

	public void setM_add(String m_add) {
		this.m_add = m_add;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public int getSuryo() {
		return suryo;
	}

	public void setSuryo(int suryo) {
		this.suryo = suryo;
	}

}
