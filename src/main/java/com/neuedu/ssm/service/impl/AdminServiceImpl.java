package com.neuedu.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.ssm.mapper.AdminMapper;
import com.neuedu.ssm.pojo.Admin;
import com.neuedu.ssm.service.AdminService;
import com.neuedu.ssm.util.ServiceUtil;


@Service
@Transactional
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminMapper mapper;
	
	public AdminMapper getMapper() {
		return mapper;
	}
	@Autowired
	public void setMapper(AdminMapper mapper) {
		this.mapper = mapper;
	}
	public AdminServiceImpl() {}
	public AdminServiceImpl(AdminMapper mapper) {
		this.mapper = mapper;
	}
//	@Cacheable(key = "'findAllA'",value = "redisCacheManager")
	public List<Admin> findAll() {
		return mapper.findAll();
	}
	public Admin findById(int id) {
		
		return mapper.findById(id);
	}
	public void update(Admin admin) {
		mapper.update(admin);
		
	}
	public void delete(int id) {
		mapper.delete(id);
		
	}
	public Admin login(String aname, String apwd) {
		Admin admin = mapper.findByName(aname);
		if(admin != null) {
			System.out.println(admin);
			if(admin.getApwd().equals(ServiceUtil.getMD5String(apwd))) {
				return admin;
			}else {
				return null;
			}
		}
		return null;
	}
	public void add(Admin admin) {
		mapper.insert(admin);
		
	}
	@Override
	public Admin findByName(String name) {
		
		return mapper.findByName(name);
	}
	

}
