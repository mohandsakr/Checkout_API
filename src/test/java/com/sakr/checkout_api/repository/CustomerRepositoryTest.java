package com.sakr.checkout_api.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerRepositoryTest {
	
	@Autowired CustomerRepository customerRepository;
	
	@Test
	void getCustomerByIdTest() {
		
		assertThat(customerRepository.getCustomersById(1)).isNotNull();
	}

}
