package com.naitech.webservices.controllers;


import com.naitech.domain.DTO.HealthFitnessDto;
import com.naitech.domain.DTO.MemberDto;
import com.naitech.logic.flow.fetchHealthFitnessFlow;
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
@RequestMapping("/member/HF")
public class HealthFitnessController {
    private fetchHealthFitnessFlow fetchHealthFitnessFlowvar;

    @Autowired
    public HealthFitnessController(fetchHealthFitnessFlow fetchHealthFitnessFlowvar) {
        this.fetchHealthFitnessFlowvar = fetchHealthFitnessFlowvar;
    }

    @GetMapping("/all")
    @ApiOperation(value="Gets all the members registered" ,notes="Returns a list of the members")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Members returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<List<HealthFitnessDto>> getAll(){
        List<HealthFitnessDto> allmembersHF = fetchHealthFitnessFlowvar.fetchHealthFitness();
        return new ResponseEntity<>(allmembersHF, HttpStatus.OK);
    }

    @ApiOperation(value="Gets a member registered health and fitness" ,notes="Returns a member's health and fitness")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Member returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    @GetMapping("/")
    public ResponseEntity<HealthFitnessDto> getMember(@RequestParam Long id){
        HealthFitnessDto memberDto = fetchHealthFitnessFlowvar.getMemberHealth(id);
        return new ResponseEntity<>(memberDto, HttpStatus.OK);
    }

}
