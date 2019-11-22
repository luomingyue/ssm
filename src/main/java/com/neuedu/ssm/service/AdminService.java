package com.neuedu.ssm.service;

import java.util.List;

import com.neuedu.ssm.pojo.Admin;


public interface AdminService {
	void add(Admin admin);
	List<Admin> findAll();
	Admin findById(int id);
	void update(Admin admin);
	void delete(int id);
	Admin login(String aname,String apwd);
	Admin findByName(String name);
}
