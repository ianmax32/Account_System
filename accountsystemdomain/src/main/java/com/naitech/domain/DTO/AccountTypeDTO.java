package com.naitech.domain.DTO;

import com.naitech.domain.persistence.AccountType;

import java.io.Serializable;
import java.time.LocalDate;

public class AccountTypeDTO implements Serializable {
    private String name;
    private LocalDate date_created;
    private String placeHolder;
    private AccountType accountType;

    public AccountTypeDTO() {
    }

    public AccountTypeDTO(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountTypeDTO(String name, LocalDate date_created, String placeHolder) {
        this.name = name;
        this.date_created = date_created;
        this.placeHolder = placeHolder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDate date_created) {
        this.date_created = date_created;
    }

    public String getPlaceHolder() {
        return placeHolder;
    }

    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }

    @Override
    public String toString() {
        return "AccountTypeDTO{" +
                "name='" + name + '\'' +
                ", date_created=" + date_created +
                ", placeHolder='" + placeHolder + '\'' +
                '}';
    }
}
