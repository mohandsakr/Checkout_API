package com.sakr.checkout_api.service.validation.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sakr.checkout_api.dto.OrderRequestDto;
import com.sakr.checkout_api.dto.Product;
import com.sakr.checkout_api.service.fraud.FraudDetectionService;
import com.sakr.checkout_api.service.validation.CheckoutRequestValidationService;

@Service
public class CheckoutRequestValidationServiceImpl implements CheckoutRequestValidationService {

	@Autowired
	private FraudDetectionService fraudDetectionService;

	@Override
	public Double validateAll(OrderRequestDto orderRequestDto) {

		Double totalPrice = getTotalMoneyAmount(orderRequestDto);

		checkMinimumBasketValue(totalPrice);
		fraudDetectionService.checkFraud(totalPrice);

		return totalPrice;

	}

	public Double getTotalMoneyAmount(OrderRequestDto orderRequestDto) {
		List<Product> productItems = orderRequestDto.getProductItems();
		Double sum = 0.0;
		for (Product product : productItems) {
			if (product.getAvailable()) {
				sum += product.getPrice();
			} else {
				throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE,
						"The prodcuts you need is not Avilable Right Now");
			}

		}

		return sum;

	}

	public void checkMinimumBasketValue(Double totalPrice) {

		if (totalPrice < 100) {
			throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "Minimum amount of total price is 100");
		}
	}

}
