package com.mobilefirstsolutions.microservices.model;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

/**
 * Created by aharcsa on 2016. 05. 16..
 */
public class Transaction {
    BigDecimal amount;
    String status;
    String sourceAccount;
    String targetAccount;
    GregorianCalendar created;
    GregorianCalendar processed;

    public String getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public String getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(String targetAccount) {
        this.targetAccount = targetAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GregorianCalendar getCreated() {
        return created;
    }

    public void setCreated(GregorianCalendar created) {
        this.created = created;
    }

    public GregorianCalendar getProcessed() {
        return processed;
    }

    public void setProcessed(GregorianCalendar processed) {
        this.processed = processed;
    }
}
