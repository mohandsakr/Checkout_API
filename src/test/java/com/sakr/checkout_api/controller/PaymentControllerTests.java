package com.sakr.checkout_api.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sakr.checkout_api.dto.TopupRequestDTO;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PaymentController.class)
public class PaymentControllerTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void topupTestWithAllCredentialsTrue() throws Exception {

		TopupRequestDTO topupRequestDTO = new TopupRequestDTO();

		topupRequestDTO.setCardNumber("123456789");
		topupRequestDTO.setPin("756");
		topupRequestDTO.setAmount(100.0);

		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/payments/topup")
						.content(new ObjectMapper().writeValueAsString(topupRequestDTO))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()

				);

	}

	@Test
	void topupTestWithAllCredentialsFalse() throws Exception {

		TopupRequestDTO topupRequestDTO = new TopupRequestDTO();

		topupRequestDTO.setCardNumber("123456789");
		topupRequestDTO.setPin("7556");
		topupRequestDTO.setAmount(100.0);

		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/payments/topup")
						.content(new ObjectMapper().writeValueAsString(topupRequestDTO))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotAcceptable()

				);

	}
	

	@Test
	void topupTestWithInsuffcientBalance() throws Exception {

		TopupRequestDTO topupRequestDTO = new TopupRequestDTO();
		topupRequestDTO.setCardNumber("123456789");
		topupRequestDTO.setPin("756");
		topupRequestDTO.setAmount(1005.0);

		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/payments/topup")
						.content(new ObjectMapper().writeValueAsString(topupRequestDTO))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isInsufficientStorage()

				);

	}
}
