package com.naitech.domain.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.naitech.domain.persistence.AccountType;
import com.naitech.domain.persistence.Member;
import com.naitech.domain.persistence.MemberTransactions;

import java.io.Serializable;
import java.time.LocalDate;

public class TransactionsDto implements Serializable {
    private double transaction_amount;
    private LocalDate date;
    private String transactionName;
    private String accountType;
    private String membername;
    private String memberSurname;

    public TransactionsDto() {
    }

    @JsonIgnore
    public TransactionsDto(MemberTransactions memberTransactions) {
        this.transaction_amount = memberTransactions.getTransaction_amount();
        this.date = memberTransactions.getDate();
        this.transactionName = memberTransactions.getTransactionName();
        this.membername = memberTransactions.getMember_id().getName();
        this.memberSurname = memberTransactions.getMember_id().getSurname();
        this.accountType = memberTransactions.getAccountType().getPlaceHolder();
    }

    public TransactionsDto(double transaction_amount, LocalDate date, Long memberID, String transactionName, String accountTypeDTO, String memberDto, String memberSurname) {
        this.transaction_amount = transaction_amount;
        this.date = date;
        this.transactionName = transactionName;
        this.accountType = accountTypeDTO;
        this.membername = memberDto;
        this.memberSurname = memberSurname;
    }

    @JsonIgnore
    public MemberTransactions buildTransaction(AccountType accountType, Member member){
        return new MemberTransactions(null, accountType, member,this.getTransaction_amount(), this.getDate(),this.getTransactionName());
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

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getMembername() {
        return membername;
    }

    public void setMembername(String membername) {
        this.membername = membername;
    }

    public String getMemberSurname() {
        return memberSurname;
    }

    public void setMemberSurname(String memberSurname) {
        this.memberSurname = memberSurname;
    }

    @Override
    public String toString() {
        return "TransactionsDto{" +
                "transaction_amount=" + transaction_amount +
                ", date=" + date +
                //", memberID=" + memberID +
                ", transactionName='" + transactionName + '\'' +
                '}';
    }
}
