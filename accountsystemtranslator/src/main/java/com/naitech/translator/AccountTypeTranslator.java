package com.naitech.translator;

import com.naitech.domain.DTO.AccountTypeDTO;
import java.util.*;

public interface AccountTypeTranslator {
    List<AccountTypeDTO> getAllAccountTypes();
    AccountTypeDTO addAccountType(AccountTypeDTO accountTypeDTO);
    void deleteAccountType(String name);
}
