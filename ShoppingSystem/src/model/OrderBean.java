package model;

import java.io.Serializable;
import java.sql.Date;

public class OrderBean implements Serializable {
	
	private int o_code;
	private String m_add;
	private Date day;
	private int t_price;

	public OrderBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getO_code() {
		return o_code;
	}

	public void setO_code(int o_code) {
		this.o_code = o_code;
	}

	public String getM_add() {
		return m_add;
	}

	public void setM_add(String m_add) {
		this.m_add = m_add;
	}

	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public int getT_price() {
		return t_price;
	}

	public void setT_price(int t_price) {
		this.t_price = t_price;
	}

}
