package com.naitech.translator;

import com.naitech.domain.DTO.SpendingDto;

import java.util.*;

public interface SpendingTranslator {
    List<SpendingDto> getSpending();
    SpendingDto getMemberSpending(Long id);
}
