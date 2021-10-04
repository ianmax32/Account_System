package com.naitech.webservices.controllers;


import com.naitech.domain.DTO.AccountTypeDTO;
import com.naitech.domain.DTO.RewardsCategoriesDto;
import com.naitech.logic.flow.FetchRewardsCategoriesFlow;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rewards-categories")
public class RewardsCategoriesController {
    private final FetchRewardsCategoriesFlow fetchRewardsCategoriesFlow;

    @Autowired
    public RewardsCategoriesController(FetchRewardsCategoriesFlow fetchRewardsCategoriesFlow) {
        this.fetchRewardsCategoriesFlow = fetchRewardsCategoriesFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value="Gets all the rewards categories" ,notes="Returns a list of rewards categories")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Rewards categories returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<List<RewardsCategoriesDto>> getAll(){
        List<RewardsCategoriesDto> rewardsCategoriesDtos = fetchRewardsCategoriesFlow.fetchRewardsCategories();
        return new ResponseEntity<>(rewardsCategoriesDtos, HttpStatus.OK);
    }

    @PutMapping("/all")
    @ApiOperation(value="Adds a new reward category" ,notes="Returns a new rewards category")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Rewards category added"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<RewardsCategoriesDto> add(@RequestBody RewardsCategoriesDto rewardsCategoriesDto){
        RewardsCategoriesDto rewardsCategoriesDtos = fetchRewardsCategoriesFlow.addRCategories(rewardsCategoriesDto);
        return new ResponseEntity<>(rewardsCategoriesDtos, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{name}")
    @ApiOperation(value="Delete a rewards category with the name" ,notes="Deletes a rewards categories with the name entered")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Rewards categories deleted"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<Boolean> deleteCategory(@RequestParam String name){
        fetchRewardsCategoriesFlow.deleteCategory(name);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


}
