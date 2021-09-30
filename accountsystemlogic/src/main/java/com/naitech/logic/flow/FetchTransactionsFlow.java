package com.naitech.logic.flow;

import com.naitech.domain.DTO.TransactionsDto;

import java.util.List;

public interface FetchTransactionsFlow {
    List<TransactionsDto> fetchTransactions();
}
