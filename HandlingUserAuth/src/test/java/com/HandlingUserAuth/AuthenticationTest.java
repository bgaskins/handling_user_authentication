package com.HandlingUserAuth;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.HandlingUserAuth.entity.UserEntity;

public class AuthenticationTest {
	@BeforeEach
	public void setup() {
		UserEntity user1 = new UserEntity("Carl", "pass", "carl@gmail.com");
		UserEntity user2 = new UserEntity("Mateo", "pass", "mateo@gmail.com");
		UserEntity user3 = new UserEntity("Nancy", "pass", "nancy@gmail.com");	
		Authentication.userList.add(user1);
		Authentication.userList.add(user2);
		Authentication.userList.add(user3);		
	}	
	
	@Test
	public void testLogin() {
		Authentication authentication = new Authentication();
		assertEquals(true, authentication.login("Carl", "pass"));		
	}	
	@Test
	public void testWrongUserLogin() {
		Authentication authentication = new Authentication();
		assertEquals(false, authentication.login("Tyler", "pass"));		
	}	
	@Test
	public void testEmailAssert() {
		Authentication authentication = new Authentication();
		assertEquals(true, authentication.login("Carl", "pass"));
		assertEquals("carl@gmail.com", authentication.getEmail());
	}	
	@Test
	public void testUserNameAssert() {
		Authentication authentication = new Authentication();
		assertEquals(true, authentication.login("Carl", "pass"));
		assertEquals("Carl", authentication.getUserName());
	}
	
	@Test
	public void testLogout() {
		Authentication authentication = new Authentication();
		assertEquals(true, authentication.login("Carl", "pass"));
		authentication.logout();
		assertEquals(null, authentication.getEmail());
	}
}
