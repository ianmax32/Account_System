package com.naitech.logic.flow.impl;

import com.naitech.domain.DTO.AccountTypeDTO;
import com.naitech.logic.flow.FetchAccountTypeFlow;
import com.naitech.translator.AccountTypeTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {
    private final AccountTypeTranslator accountTypeTranslator;

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDTO> fetchAccountType() {
        List<AccountTypeDTO> accountTypeDTOS = new ArrayList<>();
        accountTypeDTOS = accountTypeTranslator.getAllAccountTypes();
        return accountTypeDTOS;
    }
}
