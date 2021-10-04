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
    private AccountTypeDTO accountTypeDTO;
    private MemberDTO2 memberDto;

    public TransactionsDto() {
    }

    @JsonIgnore
    public TransactionsDto(MemberTransactions memberTransactions) {
        this.transaction_amount = memberTransactions.getTransaction_amount();
        this.date = memberTransactions.getDate();
        this.transactionName = memberTransactions.getTransactionName();
    }

    public TransactionsDto(double transaction_amount, LocalDate date, Long memberID, String transactionName, AccountTypeDTO accountTypeDTO, MemberDTO2 memberDto) {
        this.transaction_amount = transaction_amount;
        this.date = date;
        this.transactionName = transactionName;
        this.accountTypeDTO = accountTypeDTO;
        this.memberDto = memberDto;
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

    /*public Long getMemberID() {
        return memberID;
    }

    public void setMemberID(Long memberID) {
        this.memberID = memberID;
    }*/

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    public AccountTypeDTO getAccountTypeDTO() {
        return accountTypeDTO;
    }

    public void setAccountTypeDTO(AccountTypeDTO accountTypeDTO) {
        this.accountTypeDTO = accountTypeDTO;
    }

    public MemberDTO2 getMemberDto() {
        return memberDto;
    }

    public void setMemberDto(MemberDTO2 memberDto) {
        this.memberDto = memberDto;
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
