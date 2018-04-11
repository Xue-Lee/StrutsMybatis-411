package com.icss.dao;

import com.icss.entity.Admin;

public interface AdminDao {
	public Admin loginAdmin(String userId,String pwd);
}
