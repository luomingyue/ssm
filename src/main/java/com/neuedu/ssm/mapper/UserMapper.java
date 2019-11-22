package com.neuedu.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.neuedu.ssm.pojo.User;
@Repository
public interface UserMapper {
List<User> findAll();
	
	User findById(int id);
	
	void insert(User user);
	
	void update(User user);
	
	void delete(int id);
}
	