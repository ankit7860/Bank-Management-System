package com.bankmanagement.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {

	static Logger LOG = Logger.getLogger(ApplicationController.class.getName());

	@SuppressWarnings("unused")
	@RequestMapping(value = "/performtransaction", method = RequestMethod.POST)
	public String showTestPage(String accountNumber, @RequestParam(value = "customerName") String customerName,
			@RequestParam(value = "transactionType") String transactionType,
			@RequestParam(value = "transactionAmount") String transactionAmount,
			@RequestParam(value = "description") String description) {
		try {
			long a = Long.parseLong(accountNumber);
			double b = Double.parseDouble(transactionAmount);
			return "forward:/performtransactional";
		} catch (Exception e) {
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
			return "forward:/errors";
		}
	}

	@RequestMapping(value = "/errors" /* method = RequestMethod.GET */)
	public ModelAndView renderErrorPage(HttpServletRequest httpRequest) {

		LOG.info("method for extra exceptions like 404:Page not found");

		ModelAndView errorPage = new ModelAndView("errorPage");
		String errorMsg = "";
		int httpErrorCode = getErrorCode(httpRequest);

		switch (httpErrorCode) {
		case 400: {
			LOG.warn("Http Error Code: 400. Bad Request");
			errorMsg = "Http Error Code: 400. Bad Request";
			break;
		}
		case 401: {
			LOG.warn("Http Error Code: 401. Bad Request");
			errorMsg = "Http Error Code: 401. Unauthorized";
			break;
		}
		case 404: {
			LOG.warn("Http Error Code: 404. Bad Request");
			errorMsg = "Http Error Code: 404. Resource not found";
			break;
		}
		case 500: {
			LOG.warn("Http Error Code: 500. Bad Request");
			errorMsg = "Http Error Code: 500. Internal Server Error";
			break;
		}
		default: {
			LOG.warn("FATAL ERROR OCCURED");
			errorMsg = "FATAL ERROR OCCURED";
			break;
		}
		}
		errorPage.addObject("errorMsg", errorMsg);
		return errorPage;
	}

	private int getErrorCode(HttpServletRequest httpRequest) {
		return (Integer) httpRequest.getAttribute("javax.servlet.error.status_code");
	}
}