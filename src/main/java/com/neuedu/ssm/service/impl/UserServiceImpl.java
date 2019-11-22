package com.neuedu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.ssm.mapper.UserMapper;
import com.neuedu.ssm.pojo.User;
import com.neuedu.ssm.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper mapper;
	
	public UserMapper getMapper() {
		return mapper;
	}
	@Autowired
	public void setMapper(UserMapper mapper) {
		this.mapper = mapper;
	}

	@Override

	public List<User> findAll() {
	
		// TODO Auto-generated method stub
		return mapper.findAll();
	}
	public User findById(int id) {
		return mapper.findById(id);
	}

	public void update(User user) {
		mapper.update(user);

	}

	public void delete(int id) {
		mapper.delete(id);
	}
	public void add(User user) {
		mapper.insert(user);
		
	}

}
