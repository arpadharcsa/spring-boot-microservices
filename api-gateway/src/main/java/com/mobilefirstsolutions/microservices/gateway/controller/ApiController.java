package com.mobilefirstsolutions.microservices.gateway.controller;

import com.mobilefirstsolutions.microservices.gateway.service.TransactionHistoryService;
import com.mobilefirstsolutions.microservices.model.TransactionHistoryResponse;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by aharcsa on 2016. 05. 05..
 */
@Controller
@RequestMapping(ApiController.MAPPING)
@SuppressWarnings("unused")
public class ApiController {
    public static final String MAPPING = "/api";
    private static final String HISTORY = "gethistory";

    private TransactionHistoryService transactionHistoryService;

    @Autowired
    public void setTransactionHistoryService(TransactionHistoryService transactionHistoryService) {
        this.transactionHistoryService = transactionHistoryService;
    }

    @RequestMapping(value = HISTORY,method = RequestMethod.GET)
    @ResponseBody
    public TransactionHistoryResponse getHistory(final HttpServletRequest request) throws ServletException {
        final Claims claims = (Claims) request.getAttribute("claims");
        return transactionHistoryService.loadHistory(claims.getSubject());
    }

}
