package com.naitech.webservices.controllers;

import com.naitech.domain.DTO.DrivingDto;
import com.naitech.domain.DTO.MemberDto;
import com.naitech.domain.persistence.Member;
import com.naitech.logic.flow.FetchDrivingFlow;
import com.naitech.logic.flow.FetchMembersFlow;
import com.naitech.logic.flow.FetchSpendingFlow;
import com.naitech.logic.flow.fetchHealthFitnessFlow;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("Members")
public class MembersController {
    private final FetchMembersFlow fetchMembersFlow;
    private final FetchDrivingFlow fetchDrivingFlow;
    private final FetchSpendingFlow fetchSpendingFlow;
    private final fetchHealthFitnessFlow healthFitnessFlow;

    public MembersController(FetchMembersFlow fetchMembersFlow, FetchDrivingFlow fetchDrivingFlow, FetchSpendingFlow fetchSpendingFlow, fetchHealthFitnessFlow healthFitnessFlow) {
        this.fetchMembersFlow = fetchMembersFlow;
        this.fetchDrivingFlow = fetchDrivingFlow;
        this.fetchSpendingFlow = fetchSpendingFlow;
        this.healthFitnessFlow = healthFitnessFlow;
    }

    @Autowired


    @GetMapping("/all")
    @ApiOperation(value="Gets all the members registered" ,notes="Returns a list of the members")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Members returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    public ResponseEntity<List<MemberDto>> getAll(){
        List<MemberDto> allmembers = fetchMembersFlow.getAllMembers();
        return new ResponseEntity<>(allmembers, HttpStatus.OK);
    }

    @ApiOperation(value="Gets a member registered" ,notes="Returns a member with specified id")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Member returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    @GetMapping("/member")
    public ResponseEntity<MemberDto> getMember(@RequestParam Long id){
        MemberDto memberDto = fetchMembersFlow.getMember(id);
        return new ResponseEntity<>(memberDto, HttpStatus.OK);
    }

   /* @ApiOperation(value="Updates the plays of the member" ,notes="Returns an updated member")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Member updated"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    @PostMapping("/member/update")
    public void updateMember(@RequestBody MemberDto member){
         fetchMembersFlow.updateMember(member);
    }*/

    @ApiOperation(value="Delete a member" ,notes="Member deleted")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Member deleted"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    @DeleteMapping("/member/remove")
    public void memberDelete(@RequestParam Long id){
        fetchMembersFlow.removeMember(id);
    }

    @ApiOperation(value="Add a new member" ,notes="Member added")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Member added"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    @PutMapping("/member/add")
    //@ApiModelProperty(position = 1,required = false,value = )
    public void addMember(@RequestBody MemberDto member){
        fetchMembersFlow.addMember(member);
        fetchDrivingFlow.addMember(member);
        fetchSpendingFlow.addMember(member);
        healthFitnessFlow.addMember(member);
    }

}
