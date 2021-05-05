package com.sakr.checkout_api.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sakr.checkout_api.dto.OrderRequestDto;
import com.sakr.checkout_api.dto.TopupRequestDTO;
import com.sakr.checkout_api.entity.Customer;
import com.sakr.checkout_api.service.business.BuyService;
import com.sakr.checkout_api.service.validation.CheckoutRequestValidationService;

@Service
public class BuyServiceImpl implements BuyService {

	@Autowired
	private CheckoutRequestValidationService checkoutRequestValidationService;

	private	RestTemplate restTemplate = new RestTemplate();

	@Override
	public String checkout(Customer customer, OrderRequestDto orderRequestDto) {

		Double amount = checkoutRequestValidationService.validateAll(orderRequestDto);
		String paymentMethoURL = customer.getPaymentMethod().getURL();

		return createPaymentTopup(amount, paymentMethoURL, orderRequestDto);

	}
	

	public String createPaymentTopup(Double amount, String url, OrderRequestDto orderRequestDto) {
		
		String pin = orderRequestDto.getPin();
		String cardNumber = orderRequestDto.getCardNumber();

		TopupRequestDTO topupRequestDTO = new TopupRequestDTO();
		topupRequestDTO.setAmount(amount);
		topupRequestDTO.setCardNumber(cardNumber);
		topupRequestDTO.setPin(pin);

		ResponseEntity<String> response = this.restTemplate.postForEntity(url, topupRequestDTO, String.class);

		return response.getStatusCode().toString();
	}

}
