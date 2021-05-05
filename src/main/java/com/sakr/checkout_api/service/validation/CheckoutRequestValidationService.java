package com.sakr.checkout_api.service.validation;

import com.sakr.checkout_api.dto.OrderRequestDto;

public interface CheckoutRequestValidationService {

	public Double validateAll(OrderRequestDto orderRequestDto);
}
