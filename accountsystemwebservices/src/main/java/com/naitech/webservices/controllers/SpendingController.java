package com.naitech.webservices.controllers;


import com.naitech.domain.DTO.MemberDto;
import com.naitech.domain.DTO.SpendingDto;
import com.naitech.logic.flow.FetchSpendingFlow;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member/spending")
public class SpendingController {
    private FetchSpendingFlow fetchSpendingFlow;

    @Autowired
    public SpendingController(FetchSpendingFlow fetchSpendingFlow) {
        this.fetchSpendingFlow = fetchSpendingFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value="Gets all the members registered spending" ,notes="Returns a list of the members spending")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Members spending returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<List<SpendingDto>> getAll(){
        List<SpendingDto> allmembersspending = fetchSpendingFlow.fetchSpending();
        return new ResponseEntity<>(allmembersspending, HttpStatus.OK);
    }

    @ApiOperation(value="Gets a registered member's spending " ,notes="Returns a member's spending")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Member spending returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    @GetMapping("/")
    public ResponseEntity<SpendingDto> getMember(@RequestParam Long id){
        SpendingDto memberSpending = fetchSpendingFlow.getMemberSpending(id);
        return new ResponseEntity<>(memberSpending, HttpStatus.OK);
    }
}
