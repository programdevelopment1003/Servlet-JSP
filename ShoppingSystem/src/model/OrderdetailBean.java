package model;

import java.io.Serializable;

public class OrderdetailBean implements Serializable {
	
	private int o_code;
	private int b_id;
	private int suryo;
	private int price;
	
	public OrderdetailBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getO_code() {
		return o_code;
	}

	public void setO_code(int o_code) {
		this.o_code = o_code;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
