package com.naitech.translator;

import com.naitech.domain.DTO.TransactionsDto;

import java.util.*;

public interface TransactionsTranslator {
    List<TransactionsDto> getTransactions();
}
