package com.naitech.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Account_Type")
public class AccountType implements Serializable {
    private Long typeID;
    private String name;
    private LocalDate date_created;
    private String placeHolder;
    private Set<MemberTransactions> transactions;

    public AccountType() {
    }

    public AccountType(Long typeID, String name, LocalDate date_created, String placeHolder) {
        this.typeID = typeID;
        this.name = name;
        this.date_created = date_created;
        this.placeHolder = placeHolder;
    }

    @Id
    @SequenceGenerator(name="AT_GENERIC_SEQ",sequenceName = "AS_AC_GENERIC_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AT_GENERIC_SEQ")
    @Column(name="AccountType_ID")
    public Long getTypeID() {
        return typeID;
    }

    public void setTypeID(Long typeID) {
        this.typeID = typeID;
    }

    @Column(name="AccountType_Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="AccountType_Date_Created")
    public LocalDate getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDate date_created) {
        this.date_created = date_created;
    }

    @Column(name="AccountType_PlaceHolder", unique = true)
    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }

    @OneToMany(targetEntity = MemberTransactions.class, fetch = FetchType.LAZY,mappedBy = "accountType",orphanRemoval = false)
    public Set<MemberTransactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<MemberTransactions> transactions) {
        this.transactions = transactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(typeID, that.typeID) && Objects.equals(name, that.name) && Objects.equals(date_created, that.date_created) && Objects.equals(placeHolder, that.placeHolder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeID, name, date_created, placeHolder);
    }

    @Override
    public String toString() {
        return "AccountType{" +
                "typeID=" + typeID +
                ", name='" + name + '\'' +
                ", date_created=" + date_created +
                ", placeHolder='" + placeHolder + '\'' +
                '}';
    }
}
