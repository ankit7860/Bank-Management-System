package com.bankmanagement.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bankmanagement.exception.BankManagementException;
import com.bankmanagement.service.PerformTransactionService;
import com.bankmanagement.vo.TransactionVO;

@Controller
public class PerformTransactionController extends HandlerInterceptorAdapter {
	static Logger LOG = Logger.getLogger(PerformTransactionController.class.getName());

	@Autowired
	private Validator validator;

	@Autowired
	private PerformTransactionService performTransactionService;

	@RequestMapping(value = "performtransactional", method = RequestMethod.POST)
	public ModelAndView initialTransaction(@RequestParam(value = "accountNumber") Long accountNumber,
			@RequestParam(value = "customerName") String customerName,
			@RequestParam(value = "transactionType") String transactionType,
			@RequestParam(value = "transactionAmount") Double transactionAmount,
			@RequestParam(value = "description") String description) {

		LOG.debug("creating ModelandView object");
		LOG.info("creating ModelandView object");

		performTransactionService.init();
		TransactionVO transactionVO = new TransactionVO(accountNumber, customerName, transactionType, transactionAmount,
				description);
		Set<ConstraintViolation<TransactionVO>> validationErrors = validator.validate(transactionVO);

		LOG.info("If any validation error occure, send back to page with errors");

		if (!validationErrors.isEmpty()) {
			Map<String, String> errors = getVallidationErrors(validationErrors);
			return new ModelAndView("performTransaction","errors", errors);
		}

		try {
			Double accountBalance = performTransactionService.updateTransactionDetails(transactionVO);
			transactionVO.setTransactionAmount(transactionAmount);

			LOG.info("Transaction Successfully Completed and sending account balance to result page");
			return new ModelAndView("transactionsuccess", "message",
					"Transaction Successfully Completed. The balance available in your Account is : "
							+ accountBalance.toString());
		} catch (BankManagementException exp) {
			LOG.info("If any exception occure then send back with exceptions");
			return new ModelAndView("performTransaction", "warning", exp.getMessage());
		}
	}

	private Map<String, String> getVallidationErrors(Set<ConstraintViolation<TransactionVO>> validationErrors) {
		Map<String, String> errors = new HashMap<String, String>(validationErrors.size());
		for (ConstraintViolation<TransactionVO> constraintViolation : validationErrors) {
			errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}
		return errors;
	}
}
