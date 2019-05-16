package model;

public class CartBean {
	private String name;
	private String ption;
	private String product;
	private String produ;

	public CartBean(){

	}

	public CartBean(String name,String ption,String product,String produ){
		this.name=name;
		this.ption=ption;
		this.product=product;
		this.produ=produ;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPtopn() {
		return ption;
	}

	public void setPtopn(String ptopn) {
		this.ption = ptopn;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProdu() {
		return produ;
	}

	public void setProdu(String produ) {
		this.produ = produ;
	}


}
