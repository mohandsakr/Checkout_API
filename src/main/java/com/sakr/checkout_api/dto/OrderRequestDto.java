package com.sakr.checkout_api.dto;

import java.util.List;

public class OrderRequestDto {

	private List<Product> productItems;
	private String pin;
	private String cardNumber;

	public List<Product> getProductItems() {
		return productItems;
	}

	public void setProductItems(List<Product> productItems) {
		this.productItems = productItems;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	
	
}
