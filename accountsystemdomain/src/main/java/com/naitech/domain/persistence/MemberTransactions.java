package com.naitech.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "Member_Transactions")
public class MemberTransactions implements Serializable {
    private Long transaction_id;
    private AccountType accountType;
    private Member member_id;
    private double transaction_amount;
    private LocalDate date;
    private String transactionName;

    public MemberTransactions() {
    }

    public MemberTransactions(Long transaction_id, AccountType accountType, Member member_id, double transaction_amount, LocalDate date, String transactionName) {
        this.transaction_id = transaction_id;
        this.accountType = accountType;
        this.member_id = member_id;
        this.transaction_amount = transaction_amount;
        this.date = date;
        this.transactionName = transactionName;
    }

    @Id
    @SequenceGenerator(name="Transactions_GENERIC_SEQ",sequenceName = "AS_Transaction_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Transactions_GENERIC_SEQ")
    @Column(name="Transaction_ID")
    public Long getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Long transaction_id) {
        this.transaction_id = transaction_id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="AccountType_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="Member_ID")
    public Member getMember_id() {
        return member_id;
    }

    public void setMember_id(Member member_id) {
        this.member_id = member_id;
    }

    @Column(name="Transaction_Amount")
    public double getTransaction_amount() {
        return transaction_amount;
    }

    public void setTransaction_amount(double transaction_amount) {
        this.transaction_amount = transaction_amount;
    }

    @Column(name = "Transaction_Date")
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name = "Transaction_Name")
    public String getTransactionName() {
        return transactionName;
    }

    public void setTransactionName(String transactionName) {
        this.transactionName = transactionName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberTransactions that = (MemberTransactions) o;
        return Double.compare(that.transaction_amount, transaction_amount) == 0 && Objects.equals(transaction_id, that.transaction_id) && Objects.equals(accountType, that.accountType) && Objects.equals(member_id, that.member_id) && Objects.equals(date, that.date) && Objects.equals(transactionName, that.transactionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction_id, accountType, member_id, transaction_amount, date, transactionName);
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transaction_id=" + transaction_id +
                ", accountType=" + accountType +
                ", member_id=" + member_id +
                ", transaction_amount=" + transaction_amount +
                ", date=" + date +
                ", transactionName='" + transactionName + '\'' +
                '}';
    }
}
