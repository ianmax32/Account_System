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
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    @ApiOperation(value="Gets all the members transactions od a specified member" ,notes="Returns a list of the transactions of the member with the id")
    @ApiResponses(value={
            @ApiResponse(code=200,message="transactions for member with the id returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<List<TransactionsDto>> getMemberTransactions(@RequestParam Long id){
        List<TransactionsDto> membertransactions = fetchTransactionsFlow.getTransactionsById(id);
        return new ResponseEntity<>(membertransactions, HttpStatus.OK);
    }

    @PutMapping("/add")
    @ApiOperation(value="add a new transaction" ,notes="Adds new transaction")
    @ApiResponses(value={
            @ApiResponse(code=200,message="transaction added"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<TransactionsDto> addNewTransaction(@RequestBody TransactionsDto transactionsDto){
        TransactionsDto membertransactions = fetchTransactionsFlow.addTransaction(transactionsDto);
        return new ResponseEntity<>(membertransactions, HttpStatus.OK);
    }

}
