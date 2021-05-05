package com.sakr.checkout_api.service.authentication;

import com.sakr.checkout_api.entity.Customer;

public interface UserAuthenticationService {
	
	public Customer verify(String token);

}
