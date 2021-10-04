package com.naitech.webservices.controllers;

import com.naitech.domain.DTO.DrivingDto;
import com.naitech.domain.DTO.SpendingDto;
import com.naitech.logic.flow.FetchDrivingFlow;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members/driving")
public class DrivingController {
    FetchDrivingFlow fetchDrivingFlow;

    @Autowired
    public DrivingController(FetchDrivingFlow fetchDrivingFlow) {
        this.fetchDrivingFlow = fetchDrivingFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value="Gets all the members registered spending" ,notes="Returns a list of the members spending")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Members spending returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<List<DrivingDto>> getAll(){
        List<DrivingDto> allmembersspending = fetchDrivingFlow.fetchDriving();
        return new ResponseEntity<>(allmembersspending, HttpStatus.OK);
    }

    @ApiOperation(value="Gets a registered member's driving" ,notes="Returns the driving of member with specified id")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Driving returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    @GetMapping("/member-driving")
    public ResponseEntity<DrivingDto> getMemberDriving(@RequestParam Long id){
        DrivingDto memberDriving = fetchDrivingFlow.fetchMemberDriving(id);
        return new ResponseEntity<>(memberDriving, HttpStatus.OK);
    }

    @ApiOperation(value="Updates registered member's driving" ,notes="Member's driving is updated")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Driving updated"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    @PostMapping("/update")
    public ResponseEntity<Boolean> updateMemberDriving(@RequestParam Long id, @RequestBody DrivingDto drivingDto){
        fetchDrivingFlow.updateDriving(id,drivingDto);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

}
