package com.pms.service;

import com.pms.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
