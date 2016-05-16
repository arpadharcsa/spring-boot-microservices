package com.mobilefirstsolutions.microservices.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aharcsa on 2016. 05. 16..
 */
public class TransactionHistoryResponse {

    List<Transaction> transactions;

    public List<Transaction> getTransactions() {
        if(transactions == null){
            return new ArrayList<>();
        }
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
