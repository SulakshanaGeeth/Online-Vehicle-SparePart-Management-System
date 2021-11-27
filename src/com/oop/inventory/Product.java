package com.oop.inventory;


public class Product {
	
	private int prodID;
	private String prodCat;
	private String prodName;
	private String prodDetails;
	private String prodImg;
	private int prodPrice;
	
	public Product(int prodID, String prodCat, String prodName, String prodDetails, String prodImg, int prodPrice) {
		this.prodID = prodID;
		this.prodCat = prodCat;
		this.prodName = prodName;
		this.prodDetails = prodDetails;
		this.prodImg = prodImg;
		this.prodPrice = prodPrice;
	}

	public int getProdID() {
		return prodID;
	}

	public void setProdID(int prodID) {
		this.prodID = prodID;
	}

	public String getProdCat() {
		return prodCat;
	}

	public void setProdCat(String prodCat) {
		this.prodCat = prodCat;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDetails() {
		return prodDetails;
	}

	public void setProdDetails(String prodDetails) {
		this.prodDetails = prodDetails;
	}

	public String getProdImg() {
		return prodImg;
	}

	public void setProdImg(String prodImg) {
		this.prodImg = prodImg;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	
	
	
}
