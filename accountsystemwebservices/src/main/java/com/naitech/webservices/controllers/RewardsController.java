package com.naitech.webservices.controllers;


import com.naitech.domain.DTO.RewardsCategoriesDto;
import com.naitech.domain.DTO.RewardsDto;
import com.naitech.logic.flow.FetchRewardsFlow;
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
@RequestMapping("rewards-categories/rewards")
public class RewardsController {
    private final FetchRewardsFlow fetchRewardsFlow;

    @Autowired
    public RewardsController(FetchRewardsFlow fetchRewardsFlow) {
        this.fetchRewardsFlow = fetchRewardsFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value="Gets all the rewards for a category" ,notes="Returns a list of rewards")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Rewards returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<List<RewardsDto>> getAll(){
        List<RewardsDto> rewardsDtos = fetchRewardsFlow.fetchRewards();
        return new ResponseEntity<>(rewardsDtos, HttpStatus.OK);
    }
}
