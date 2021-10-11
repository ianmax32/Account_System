package com.naitech.logic.flow.impl;

import com.naitech.domain.DTO.AccountTypeDTO;
import com.naitech.logic.flow.FetchAccountTypeFlow;
import com.naitech.translator.AccountTypeTranslator;
import jdk.nashorn.internal.runtime.options.LoggingOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {
    private final AccountTypeTranslator accountTypeTranslator;

    private static final Logger LOGGER = LoggerFactory.getLogger(FetchAccountTypeFlowImpl.class);

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDTO> fetchAccountType() {
        List<AccountTypeDTO> accountTypeDTOS = new ArrayList<>();
        accountTypeDTOS = accountTypeTranslator.getAllAccountTypes();
        LOGGER.info("Information for the Account types fetched {}", accountTypeDTOS);
        return accountTypeDTOS;
    }

    @Override
    public AccountTypeDTO addAccountType(AccountTypeDTO accountTypeDTO) {
        LOGGER.info("Infromation for the Account types added {}", accountTypeTranslator.addAccountType(accountTypeDTO));
        return accountTypeTranslator.addAccountType(accountTypeDTO);
    }

    @Override
    public void deleteAccountType(String name) {
        accountTypeTranslator.deleteAccountType(name);
    }
}
