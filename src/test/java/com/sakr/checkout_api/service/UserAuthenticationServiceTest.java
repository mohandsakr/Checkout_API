package com.sakr.checkout_api.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sakr.checkout_api.service.authentication.UserAuthenticationService;

@SpringBootTest
public class UserAuthenticationServiceTest {

	@Autowired
	UserAuthenticationService userAuthenticationService;

	@Test
	public void verifyTest() {
		
		assertThat(userAuthenticationService.verify("1-35")).isNotNull();
		assertThat(userAuthenticationService.verify("135-50")).isNull();
	}

}
