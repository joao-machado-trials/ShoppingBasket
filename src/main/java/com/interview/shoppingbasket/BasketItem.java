package com.interview.shoppingbasket;

import lombok.Data;

@Data
public class BasketItem {
    private String productCode;
    private String productName;
    private int quantity;
    private double productRetailPrice;

    public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getProductRetailPrice() {
		return productRetailPrice;
	}
	public void setProductRetailPrice(double productRetailPrice) {
		this.productRetailPrice = productRetailPrice;
	}
}
