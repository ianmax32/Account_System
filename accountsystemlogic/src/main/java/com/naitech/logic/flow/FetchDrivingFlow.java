package com.naitech.logic.flow;

import com.naitech.domain.DTO.DrivingDto;
import java.util.*;

public interface FetchDrivingFlow {
    List<DrivingDto> fetchDriving();
    DrivingDto fetchMemberDriving(Long id);
}
