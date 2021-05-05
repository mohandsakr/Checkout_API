package com.sakr.checkout_api.service.authentication.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sakr.checkout_api.entity.Customer;
import com.sakr.checkout_api.repository.CustomerRepository;
import com.sakr.checkout_api.service.authentication.UserAuthenticationService;
@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {

	
	private @Autowired CustomerRepository  customerRepository;
	@Override
	public Customer verify(String token) {
		
		int index=token.indexOf('-');
		Integer  customerId= Integer.parseInt(token.substring(0,index));
		return customerRepository.getCustomersById(customerId);
		
	}

}
