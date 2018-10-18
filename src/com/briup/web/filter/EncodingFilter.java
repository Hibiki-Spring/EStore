package com.briup.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class EncodingFilter implements Filter{
	
	//过滤器销毁的方法
	@Override
	public void destroy() {
		
	}

	//对资源进行校验
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		//放行(原来该请求什么资源接着请求什么资源)
		chain.doFilter(req, res);
	}
	
	//初始化过滤器用的
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
