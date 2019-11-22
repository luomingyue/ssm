package com.neuedu.ssm.service;

import java.util.List;

import com.neuedu.ssm.pojo.User;

public interface UserService {
	void add(User user);
	List<User> findAll();
	User findById(int id);
	void update(User user);
	void delete(int id);
}
