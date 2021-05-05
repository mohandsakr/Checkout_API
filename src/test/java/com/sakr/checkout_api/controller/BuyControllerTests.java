package com.sakr.checkout_api.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sakr.checkout_api.dto.OrderRequestDto;
import com.sakr.checkout_api.dto.Product;
import com.sakr.checkout_api.service.authentication.UserAuthenticationService;
import com.sakr.checkout_api.service.business.BuyService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BuyController.class)
@ActiveProfiles("test")
public class BuyControllerTests {

	@MockBean
	BuyService buyService;

	@MockBean
	UserAuthenticationService userAuthenticationService;

	@Autowired
	MockMvc mockMvc;

	@Test
	void getCountriesCodesTest() throws Exception {

		OrderRequestDto orderRequestDto = new OrderRequestDto();

		List<Product> productList = new ArrayList<>();

		Product product = new Product();
		product.setAvailable(true);
		product.setPrice(100.0);

		orderRequestDto.setProductItems(productList);
		orderRequestDto.setCardNumber("123456789");
		orderRequestDto.setPin("756");

		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/checkout").header("user_token", "1-35")
						.content(new ObjectMapper().writeValueAsString(orderRequestDto))
						.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()

				);

	}

}
