package com.naitech.logic.flow;

import com.naitech.domain.DTO.DrivingDto;
import com.naitech.domain.DTO.MemberDto;

import java.util.*;

public interface FetchDrivingFlow {
    List<DrivingDto> fetchDriving();
    DrivingDto fetchMemberDriving(Long id);
    DrivingDto addMember(MemberDto drivingDto);
    void updateDriving(Long id, DrivingDto drivingDto);
}
