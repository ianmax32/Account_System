package com.naitech.domain.DTO;

import com.naitech.domain.persistence.AccountType;
import com.naitech.domain.persistence.Member;
import com.naitech.domain.persistence.Transactions;

import java.io.Serializable;
import java.time.LocalDate;

public class TransactionsDto implements Serializable {
    private double transaction_amount;
    private LocalDate date;
    private Long memberID;
    private String transactionName;

    public TransactionsDto() {
    }


    public TransactionsDto(Transactions transactions) {
        super();
        this.transaction_amount = transactions.getTransaction_amount();
        this.date = transactions.getDate();
        this.memberID = transactions.getMember_id().getIdNUmber();
        this.transactionName = transactions.getTransactionName();
    }

    public TransactionsDto(double transaction_amount, LocalDate date, Long memberID, String transactionName) {
        this.transaction_amount = transaction_amount;
        this.date = date;
        this.memberID = memberID;
        this.transactionName = transactionName;
    }

    public double getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(double transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    @Override
    public String toString() {
        return "TransactionsDto{" +
                "transaction_amount=" + transaction_amount +
                ", date=" + date +
                ", memberID=" + memberID +
                ", transactionName='" + transactionName + '\'' +
                '}';
    }
}
