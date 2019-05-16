package model;

public class ProduBean {
	private String Productname;
	private String Categoriesname;
	private String Description;
	private String price;

	public ProduBean() {}

	public ProduBean(String Productname,String Categoriesname,String Description,String price){
		this.Productname=Productname;
		this.Categoriesname=Categoriesname;
		this.Description=Description;
		this.price=price;
	}

	public String getProductname() {
		return Productname;
	}

	public void setProductname(String productname) {
		Productname = productname;
	}

	public String getCategoriesname() {
		return Categoriesname;
	}

	public void setCategoriesname(String categoriesname) {
		Categoriesname = categoriesname;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}



}
