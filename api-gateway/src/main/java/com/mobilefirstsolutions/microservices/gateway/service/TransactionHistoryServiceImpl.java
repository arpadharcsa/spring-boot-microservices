package com.mobilefirstsolutions.microservices.gateway.service;

import com.mobilefirstsolutions.microservices.model.TransactionHistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by aharcsa on 2016. 05. 16..
 */
@Service
public class TransactionHistoryServiceImpl implements TransactionHistoryService {
    private static final String TRANSACTION_HISTORY_SERVICE = "http://transaction-history-service/api";
    private static final String HISTORY = "history";
    protected RestTemplate restTemplate;

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public TransactionHistoryResponse loadHistory(String username) {
        return restTemplate.getForObject(TRANSACTION_HISTORY_SERVICE + "/" + HISTORY + "/" + username, TransactionHistoryResponse.class);
    }
}
