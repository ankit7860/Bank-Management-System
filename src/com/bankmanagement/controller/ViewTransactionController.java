package com.bankmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.service.ViewTransactionService;
import com.bankmanagement.vo.TransactionVO;

@Controller
public class ViewTransactionController {
	static Logger log = Logger.getLogger(PerformTransactionController.class.getName());

	@Autowired
	private ViewTransactionService viewTransactionService;

	@RequestMapping(value = "jsp/viewTransaction", method = RequestMethod.GET)
	public ModelAndView searchUserTransaction(@RequestParam("accountNumber") Long accountNumber,
			@RequestParam("transactionId") Long transactionId) throws BankManagementException {
		try {
			List<TransactionVO> details = new ArrayList<TransactionVO>();
			ModelAndView model = null;
			log.info("calling retreiveTransactionDetails in searchUserTransaction");
			details = viewTransactionService.retreiveTransactionDetails(accountNumber, transactionId);
			model = new ModelAndView("transactiondetails", "details", details);
			return model;
		} catch (BankManagementException exc) {
			exc.getMessage();
			log.warn("FATAL ERROR OCCURED in searchUserTransaction");
			return new ModelAndView("viewTransaction", "message", exc.getMessage());
		}
	}
}
