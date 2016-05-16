package com.mobilefirstsolutions.microservices.gateway.service;

import com.mobilefirstsolutions.microservices.model.TransactionHistoryResponse;

/**
 * Created by aharcsa on 2016. 05. 16..
 */
public interface TransactionHistoryService {

    /**
     * Get transaction history
     * @return TransactionHistoryResponse
     */
    TransactionHistoryResponse loadHistory(String username);
}
