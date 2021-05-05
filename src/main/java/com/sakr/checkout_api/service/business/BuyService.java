package com.sakr.checkout_api.service.business;

import com.sakr.checkout_api.dto.OrderRequestDto;
import com.sakr.checkout_api.entity.Customer;

public interface BuyService {
	
public String checkout(Customer customer,OrderRequestDto orderRequestDto);

}
