package com.liferaysavvy.servletfilter;

import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class LiferayIPAddressServletFilter implements Filter {

	public void init(FilterConfig config) throws ServletException {

		logger.info("Init method being called");

		/*
		 * If we define init parameter in web.xml the following method retrive
		 * the configured value
		 */
		String intiParamValue = config.getInitParameter("initparam");
		logger.info("intiParamValue: " + intiParamValue);
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws java.io.IOException, ServletException {

		logger.info("DoFilter method being called");

		/* Retrive the IP address of client from where user requested */
		String clientIPAddress = request.getRemoteAddr();

		// Display or save the IP address of requested client.
		logger.info("Requested Client IP Address" + clientIPAddress + ", Time "
				+ new Date().toString());

		/* Pass request back down the filter chain */
		chain.doFilter(request, response);
	}

	public void destroy() {
		/*
		 * This method will be executed when we undeploy application or stop
		 * server
		 */
		logger.info("Destroy method being called");
	}

	private static final Log logger = LogFactoryUtil
			.getLog(LiferayIPAddressServletFilter.class);
}
