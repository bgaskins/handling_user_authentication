package com.HandlingUserAuth;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import com.HandlingUserAuth.entity.UserEntity;

public class Authentication {
	
	public static Set<UserEntity> userList = new HashSet<>();
	private UserEntity currentSessionUser = null;

	public Boolean login(String userName, String password) {

		AtomicBoolean userExists = new AtomicBoolean(false);
		userList.stream().filter(x -> x.getUserName().equals(userName) && x.getPassword().equals(password))
				.findFirst()
				.ifPresent(x -> {
					userExists.set(true);
					currentSessionUser = x;
				});
		return userExists.get();

	}
	
	public String getEmail() {
		if(currentSessionUser !=null) {
			return currentSessionUser.getEmail();
		}
		return  null;
	}
	
	public String getUserName() {
		if(currentSessionUser !=null) {
			return currentSessionUser.getUserName();
		}
		return  null;
	}

	public void logout() {
		currentSessionUser = null;
	}
}
