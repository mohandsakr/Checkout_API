package com.sakr.checkout_api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sakr.checkout_api.dto.OrderRequestDto;
import com.sakr.checkout_api.dto.Product;
import com.sakr.checkout_api.entity.Customer;
import com.sakr.checkout_api.entity.PaymentMethod;
import com.sakr.checkout_api.service.validation.CheckoutRequestValidationService;

@SpringBootTest
public class CheckoutRequestValidationServiceTest {

	@Autowired
	CheckoutRequestValidationService checkoutRequestValidationService;

	@Test
	public void validateAllTest() {
		OrderRequestDto orderRequestDto = createData();
		assertEquals(checkoutRequestValidationService.validateAll(orderRequestDto), 150);
	}

	
	public OrderRequestDto createData() {
		PaymentMethod paymentMethod = new PaymentMethod();
		paymentMethod.setId(1);
		paymentMethod.setURL("http://localhost:8090/payments/topup");

		Customer customer = new Customer();
		customer.setBalance(100.0);
		customer.setCardNumber("123456789");
		customer.setPin("756");
		customer.setPaymentMethod(paymentMethod);
		OrderRequestDto orderRequestDto = new OrderRequestDto();
		List<Product> productlist = new ArrayList<>();
		Product product = new Product();
		product.setAvailable(true);
		product.setPrice(150.0);
		productlist.add(product);
		orderRequestDto.setProductItems(productlist);

		return orderRequestDto;
	}
}
