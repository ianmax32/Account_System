package com.naitech.logic.flow;

import com.naitech.domain.DTO.AccountTypeDTO;

import java.util.List;

public interface FetchAccountTypeFlow {
    List<AccountTypeDTO> fetchAccountType();
    AccountTypeDTO addAccountType(AccountTypeDTO accountTypeDTO);
    void deleteAccountType(String name);
}
