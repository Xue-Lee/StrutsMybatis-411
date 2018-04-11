package com.icss.action;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.struts2.ServletActionContext;

import com.icss.dao.AdminDao;
import com.icss.dao.ClientDao;
import com.icss.entity.Admin;
import com.icss.entity.Client;
import com.icss.util.MybatisUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Action extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private List<Client> clist;
	private String userId;
	private String pwd;

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public List<Client> getClist() {
		return clist;
	}
	public String execute() {
		System.out.println("show--------");
		SqlSession sqlsession = MybatisUtil.getSqlSession();
		ClientDao dao = sqlsession.getMapper(ClientDao.class);
		clist = dao.findClientAll();
		return "success";
	}
	

	public String test1() {
		System.out.println("test1--------");
		SqlSession sqlsession = MybatisUtil.getSqlSession();
		ClientDao dao = sqlsession.getMapper(ClientDao.class);
		clist = dao.findClientAll();
		return "success";
	}
	
	public String login() {
		System.out.println("login--------");
		SqlSession sqlsession = MybatisUtil.getSqlSession();
		AdminDao dao = sqlsession.getMapper(AdminDao.class);
		Admin admin = dao.loginAdmin(userId, pwd);
		if(admin != null) {
			ServletActionContext.getRequest().getSession().setAttribute("user", admin);
			return SUCCESS;
		}else {
			return LOGIN;
		}
	}
	
	public String test2(){
		System.out.println("test2----------------------");
		ActionContext act=ActionContext.getContext();
		act.put("user", "任我行");
		Map<String, Object> session = act.getSession();
		session.put("city", "天津市");
		return SUCCESS;
	}
}
