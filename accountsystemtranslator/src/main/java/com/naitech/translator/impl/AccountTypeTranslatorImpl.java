package com.naitech.translator.impl;

import com.naitech.domain.DTO.AccountTypeDTO;
import com.naitech.domain.persistence.AccountType;
import com.naitech.repository.persistence.AccountTypeRepo;
import com.naitech.translator.AccountTypeTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountTypeTranslatorImpl implements AccountTypeTranslator {
    private final AccountTypeRepo accountTypeRepo;

    @Autowired
    public AccountTypeTranslatorImpl(AccountTypeRepo accountTypeRepo) {
        this.accountTypeRepo = accountTypeRepo;
    }

    @Override
    public List<AccountTypeDTO> getAllAccountTypes() {
        List<AccountTypeDTO> accountTypeDTOS = new ArrayList<>();
        try {
            for(AccountType accountType:accountTypeRepo.findAll()){
                accountTypeDTOS.add(new AccountTypeDTO(accountType));
            }
        }catch (Exception e){
            throw new RuntimeException("Unable to read from DB",e);
        }
        return accountTypeDTOS;
    }
}
