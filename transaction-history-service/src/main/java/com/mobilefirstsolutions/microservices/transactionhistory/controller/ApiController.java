package com.mobilefirstsolutions.microservices.transactionhistory.controller;

import com.mobilefirstsolutions.microservices.model.Transaction;
import com.mobilefirstsolutions.microservices.model.TransactionHistoryResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by aharcsa on 2016. 05. 05..
 */
@Controller
@RequestMapping(ApiController.MAPPING)
@SuppressWarnings("unused")
public class ApiController {
    public static final String MAPPING = "api";
    private static final String GET_HISTORY = "history";

    Map<String,List<Transaction>> transactionHistory;

    public ApiController() {
        transactionHistory = new HashMap<>();
        List<Transaction> transactions = new ArrayList<>();

        Transaction item = new Transaction();
        item.setAmount(new BigDecimal("1000"));
        item.setSourceAccount("11111111-11111111");
        item.setTargetAccount("11111111-11111112");
        item.setCreated(new GregorianCalendar());
        item.setProcessed(new GregorianCalendar());
        item.setStatus("processed");
        transactions.add(item);

        Transaction item2 = new Transaction();
        item2.setAmount(new BigDecimal("26"));
        item2.setSourceAccount("11111111-11111111");
        item2.setTargetAccount("11111111-11111113");
        item2.setCreated(new GregorianCalendar());
        item2.setProcessed(new GregorianCalendar());
        item2.setStatus("in progress");
        transactions.add(item2);

        Transaction item3 = new Transaction();
        item3.setAmount(new BigDecimal("7200"));
        item3.setSourceAccount("11111111-11111111");
        item3.setTargetAccount("11111111-11111114");
        item3.setCreated(new GregorianCalendar());
        item3.setProcessed(new GregorianCalendar());
        item3.setStatus("in progress");
        transactions.add(item3);
        transactionHistory.put("arpi", transactions);


        List<Transaction> transactions2 = new ArrayList<>();
        Transaction item4 = new Transaction();
        item4.setAmount(new BigDecimal("9000"));
        item4.setSourceAccount("11111123-11111121");
        item4.setTargetAccount("11111111-11111342");
        item4.setCreated(new GregorianCalendar());
        item4.setProcessed(new GregorianCalendar());
        item4.setStatus("processed");
        transactions2.add(item4);
        Transaction item5 = new Transaction();
        item5.setAmount(new BigDecimal("69"));
        item5.setSourceAccount("11123123-11111121");
        item5.setTargetAccount("11111111-11311342");
        item5.setCreated(new GregorianCalendar());
        item5.setProcessed(new GregorianCalendar());
        item5.setStatus("in progress");
        transactions2.add(item5);

        transactionHistory.put("bela",transactions2);
    }

    @RequestMapping(value = GET_HISTORY + "/{userName}",method = RequestMethod.GET)
    @ResponseBody
    public TransactionHistoryResponse getHistory(@PathVariable final String userName){
        TransactionHistoryResponse response = new TransactionHistoryResponse();
        response.setTransactions(transactionHistory.get(userName));
        return response;
    }

    @RequestMapping(value = GET_HISTORY ,method = RequestMethod.GET)
    @ResponseBody
    public TransactionHistoryResponse getHistory(){
        TransactionHistoryResponse response = new TransactionHistoryResponse();
        response.setTransactions(new ArrayList<>());
        return response;
    }
}
