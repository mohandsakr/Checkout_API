package com.sakr.checkout_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sakr.checkout_api.dto.TopupRequestDTO;

@RestController
@RequestMapping("/payments")
public class PaymentController {

	@PostMapping("/topup")
	void topup(@RequestBody TopupRequestDTO topupRequestDTO) {

		String cardNumber = topupRequestDTO.getCardNumber();
		String pin = topupRequestDTO.getPin();
		Double amount = topupRequestDTO.getAmount();

		if (cardNumber.equals("123456789") && pin.equals("756")) {

			if (amount > 1000) {
				throw new ResponseStatusException(HttpStatus.INSUFFICIENT_STORAGE, " No sufficient Balance ");
			}

		} else {

			throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,
					"The payment credentials you provide isn't correct please review and try again later");
		}

	}

}
