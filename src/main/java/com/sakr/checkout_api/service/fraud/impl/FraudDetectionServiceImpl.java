package com.sakr.checkout_api.service.fraud.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sakr.checkout_api.service.fraud.FraudDetectionService;

@Service
public class FraudDetectionServiceImpl implements FraudDetectionService {

	@Override
	public void checkFraud(Double totalPrice) {
		
		if (totalPrice > 1500) {
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "There is a Fraud Detected ");
		}


	}

}
