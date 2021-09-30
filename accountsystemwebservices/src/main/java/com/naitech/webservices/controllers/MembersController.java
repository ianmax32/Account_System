package com.naitech.webservices.controllers;

import com.naitech.domain.DTO.DrivingDto;
import com.naitech.domain.DTO.MemberDto;
import com.naitech.domain.persistence.Member;
import com.naitech.logic.flow.FetchMembersFlow;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("Members")
public class MembersController {
    private final FetchMembersFlow fetchMembersFlow;

    @Autowired
    public MembersController(FetchMembersFlow fetchMembersFlow) {
        this.fetchMembersFlow = fetchMembersFlow;
    }

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

    @ApiOperation(value="Updates the plays of the member" ,notes="Returns an updated member")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Member updated"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    @PostMapping("/member/update")
    public void updateMember(@RequestParam Long id,@RequestBody Member member){
         fetchMembersFlow.updateMember(id);
    }

    @ApiOperation(value="Gets a member registered" ,notes="Returns a member with specified id")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Member returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    @DeleteMapping("/member/remove")
    public void memberDelete(@RequestParam Long id){
        fetchMembersFlow.removeMember(id);
    }

    @ApiOperation(value="Gets a member registered" ,notes="Returns a member with specified id")
    @ApiResponses(value={
            @ApiResponse(code=200,message="Member returned"),
            @ApiResponse(code=400,message="Bad request"),
            @ApiResponse(code=404,message="Not found"),
            @ApiResponse(code=500,message="Internal Server error")
    })
    @PutMapping("/member/add")
    public void getMember(@RequestBody MemberDto member){
        fetchMembersFlow.addMember(member);
    }

}
