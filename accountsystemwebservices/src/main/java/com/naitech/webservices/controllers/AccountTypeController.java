package com.naitech.webservices.controllers;

import com.naitech.domain.DTO.AccountTypeDTO;
import com.naitech.domain.DTO.MemberDto;
import com.naitech.logic.flow.FetchAccountTypeFlow;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account-type")
public class AccountTypeController {
    private final FetchAccountTypeFlow fetchAccountTypeFlow;

    @Autowired
    public AccountTypeController(FetchAccountTypeFlow fetchAccountTypeFlow) {
        this.fetchAccountTypeFlow = fetchAccountTypeFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value="Gets all the account types added" ,notes="Returns a list of account types for members")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Account types returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<List<AccountTypeDTO>> getAll(){
        List<AccountTypeDTO> accountTypeDTOS = fetchAccountTypeFlow.fetchAccountType();
        return new ResponseEntity<>(accountTypeDTOS, HttpStatus.OK);
    }

    @PutMapping("/add")
    @ApiOperation(value="Adda new account type" ,notes="Returns a an account type that was added")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Account types added"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<AccountTypeDTO> addAccountType(@RequestBody AccountTypeDTO accountTypeDTO){
        AccountTypeDTO accountTypeDTOS = fetchAccountTypeFlow.addAccountType(accountTypeDTO);
        return new ResponseEntity<>(accountTypeDTOS, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    @ApiOperation(value="Delete the account types with the name entered" ,notes="An account type with the name entered is deleted")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Account types delete"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<Boolean> deleteAccountType(@RequestParam String name){
        fetchAccountTypeFlow.deleteAccountType(name);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
