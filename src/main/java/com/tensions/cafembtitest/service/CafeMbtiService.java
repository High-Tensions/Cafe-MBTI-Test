package com.tensions.cafembtitest.service;

import com.tensions.cafembtitest.dto.CafeMbtiDTO;

public interface CafeMbtiService {
    String mbtiResult(CafeMbtiDTO cafeMbtiDTO);

    float mbtiPercent(String result);

    int getPeopleCount();
}
