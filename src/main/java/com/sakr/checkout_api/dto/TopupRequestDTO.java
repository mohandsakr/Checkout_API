package com.sakr.checkout_api.dto;

public class TopupRequestDTO {

	private String cardNumber;
	private	String pin;
	private Double amount;
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
 
	
	
	
	
	
}
