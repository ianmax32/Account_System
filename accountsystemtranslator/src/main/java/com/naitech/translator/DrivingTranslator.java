package com.naitech.translator;

import com.naitech.domain.DTO.DrivingDto;

import java.util.*;

public interface DrivingTranslator {
    List<DrivingDto> getDriving();
    DrivingDto getMemberDriving(Long id);
}
