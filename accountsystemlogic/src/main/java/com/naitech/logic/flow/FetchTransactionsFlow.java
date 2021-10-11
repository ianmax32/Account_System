package com.naitech.logic.flow;

import com.naitech.domain.DTO.TransactionsDto;

import java.util.List;

public interface FetchTransactionsFlow {
    List<TransactionsDto> fetchTransactions();
    TransactionsDto addTransaction(TransactionsDto transactionsDto);
    List<TransactionsDto> getTransactionsById(Long id);
    void updateMemberAmount(Long id, TransactionsDto transactionsDto);
}
