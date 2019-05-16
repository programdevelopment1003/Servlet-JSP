package model;

public class AddtoBean {
	private String name;
	private String Descr;
	private String price;
	private String Description;

	public AddtoBean(String name,String Descr,String price,String Description){
		this.name=name;
		this.Descr=Descr;
		this.price=price;
		this.Description=Description;

	}

	public AddtoBean(){}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return Descr;
	}

	public void setDescr(String descr) {
		Descr = descr;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}



}
