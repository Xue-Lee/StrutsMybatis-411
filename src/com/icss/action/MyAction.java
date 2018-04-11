package com.icss.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;

public class MyAction implements ServletRequestAware {

	private HttpServletRequest request;
	private HttpServletResponse response;
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// 系统注入Request
		request = arg0;
	}
	
	public void setServletResponse(HttpServletResponse arg0) {
		response = arg0;
	}
	public String fun1(){
		request.setAttribute("admin", "刘备");
		return "success";
	}
}
