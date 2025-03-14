package com.tensions.cafembtitest.service;

import com.tensions.cafembtitest.dto.CafeMbtiDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CafeMbtiService {
    String mbtiResult(CafeMbtiDTO cafeMbtiDTO);

    float mbtiPercent(String result);

    int getPeopleCount();

    // mbti 질문,답변 리스트 조회
    List<Map<String,String>> selectMbtiQuestion(String num);
}
