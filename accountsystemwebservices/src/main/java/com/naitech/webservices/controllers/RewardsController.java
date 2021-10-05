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
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/add")
    @ApiOperation(value="add a new reward for a category" ,notes="Returns an added reward")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Reward added"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<RewardsDto> addReward(@RequestBody RewardsDto rewardsDto){
        RewardsDto rewardsDtos = fetchRewardsFlow.addReward(rewardsDto);
        return new ResponseEntity<>(rewardsDtos, HttpStatus.OK);
    }

    @GetMapping("/reward/{id}")
    @ApiOperation(value="Gets a rewards for a category" ,notes="Returns a reward with the id specified")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Reward returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<RewardsDto> getReward(@RequestParam Long id){
        RewardsDto rewardsDtos = fetchRewardsFlow.getReward(id);
        return new ResponseEntity<>(rewardsDtos, HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    @ApiOperation(value="Updates a rewards in a category" ,notes="Returns an updated reward")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Reward updated"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<Boolean> update(@RequestParam Long id, @RequestBody RewardsDto rewardsDto){
        fetchRewardsFlow.updateRewardPrice(id, rewardsDto);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    @ApiOperation(value="Delete a rewards with the specified id" ,notes="Deletes a reward")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Reward deleted"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<Boolean> delete(@RequestParam Long id){
        fetchRewardsFlow.deleteReward(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
