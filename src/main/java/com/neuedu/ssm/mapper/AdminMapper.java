package com.neuedu.ssm.mapper;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.neuedu.ssm.pojo.Admin;


@Repository
public interface AdminMapper {
	List<Admin> findAll();
	
	Admin findById(int id);
	
	void insert(Admin admin);
	
	void update(Admin admin);
	
	void delete(int id);
	Admin findByName(String aname);
}
