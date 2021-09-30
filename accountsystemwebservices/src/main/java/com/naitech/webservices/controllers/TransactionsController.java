package com.naitech.webservices.controllers;

import com.naitech.domain.DTO.MemberDto;
import com.naitech.domain.DTO.TransactionsDto;
import com.naitech.logic.flow.FetchTransactionsFlow;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("member/transactions")
public class TransactionsController {
    private final FetchTransactionsFlow fetchTransactionsFlow;

    @Autowired
    public TransactionsController(FetchTransactionsFlow fetchTransactionsFlow) {
        this.fetchTransactionsFlow = fetchTransactionsFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value="Gets all the members transactions" ,notes="Returns a list of the transactions of the members")
    @ApiResponses(value={
            @ApiResponse(code=200,message="transactions returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<List<TransactionsDto>> getAll(){
        List<TransactionsDto> allmemberstransactions = fetchTransactionsFlow.fetchTransactions();
        return new ResponseEntity<>(allmemberstransactions, HttpStatus.OK);
    }


}
