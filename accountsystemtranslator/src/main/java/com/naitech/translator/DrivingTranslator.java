package com.naitech.translator;

import com.naitech.domain.DTO.DrivingDto;
import com.naitech.domain.DTO.MemberDto;

import java.util.*;

public interface DrivingTranslator {
    List<DrivingDto> getDriving();
    DrivingDto getMemberDriving(Long id);
    DrivingDto addDriving(MemberDto memberDtoDto);
    void updateDriving(Long id, DrivingDto drivingDto);
}
