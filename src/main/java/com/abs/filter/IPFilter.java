package com.abs.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.abs.entity.IpRecord;
import com.abs.service.IpRecordService;
import com.abs.util.IPUtil;

public class IPFilter implements Filter  {
    
	//FilterConfig可用于访问Filter的配置信息  
	private FilterConfig config;  
	private IpRecordService ipRecordService;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		ServletContext context = req.getSession().getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
		if (ctx != null && ctx.getBean("ipRecordService") != null) {
			ipRecordService = (IpRecordService)ctx.getBean("ipRecordService");
		}
		IpRecord ip = new IpRecord();
		ip.setIp(IPUtil.getIp(req));
		ip.setCreatedatetime(new Date());
		ipRecordService.save(ip);
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
