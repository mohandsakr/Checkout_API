package com.sakr.checkout_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sakr.checkout_api.dto.OrderRequestDto;
import com.sakr.checkout_api.entity.Customer;
import com.sakr.checkout_api.service.authentication.UserAuthenticationService;
import com.sakr.checkout_api.service.business.BuyService;

@RestController
@RequestMapping
public class BuyController {

	@Autowired
	private BuyService buyService;
	@Autowired
	private UserAuthenticationService userAuthenticationService;

	@PostMapping("/checkout")
	String checkout(@RequestHeader(name = "user_token") String userToken,
			@RequestBody OrderRequestDto orderRequestDto) {
		Customer customer = userAuthenticationService.verify(userToken);

		if (customer == null) {

			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
					"This user Doesn't exist please check and try again ");
		}

		return buyService.checkout(customer, orderRequestDto);

	}
}
