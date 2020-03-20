package com.anurag.users.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.anurag.users.service.UsersService;
import com.anurag.users.service.UsersServiceImpl;
import org.junit.Assert;
class UserRegistrationTestCases {
	UsersService service = null;
	@BeforeEach
	public void setUp()
	{
		service = new UsersServiceImpl();
	}
	@AfterEach
	public void tearDown()
	{
		service=null;
	}
	@Test
	void testValidatePhonePositive() {
		Assert.assertEquals(true,service.validatePhoneNo(9652472336L));
	}
	@Test
	void testValidatePhoneNegative() {
		Assert.assertNotEquals(true,service.validatePhoneNo(965247233L));
		Assert.assertNotEquals(true,service.validatePhoneNo(06524723L));
	}
	@Test
	void testValidateEmailPositive() {
		Assert.assertEquals(true,service.validateEmail("vinoothnareddyginjala@gmail.com"));
	}
	@Test
	void testValidateEmailNegative() {
		Assert.assertNotEquals(true,service.validateEmail("vin_abc@gmail.com"));
	}
	@Test
	void testValidateUserIdPositive() {
		Assert.assertEquals(true,service.validateUserId(123456789090L));
	}
	@Test
	void testValidateUserIdNegative() {
		Assert.assertNotEquals(true,service.validateUserId(1234L));
	}
}
