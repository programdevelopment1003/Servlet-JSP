package model;

import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;

public class BookBean implements Serializable {
	
	private int b_id;
	private String b_name;
	private String b_namey;
	private int price;
	private int a_id;
	private int g_id;
	private int stock;
	private Blob picture;

	public BookBean() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public BookBean(int b_id,String b_name,String b_namey,int price,int a_id,int g_id,int stock,Blob picture){
		this.b_id = b_id;
		this.b_name = b_name;
		this.b_namey = b_namey;
		this.price = price;
		this.a_id = a_id;
		this.g_id = g_id;
		this.stock = stock;
		this.picture = picture;
	}

	public int getB_id() {
		return b_id;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public String getB_namey() {
		return b_namey;
	}

	public void setB_namey(String b_namey) {
		this.b_namey = b_namey;
	}

}
