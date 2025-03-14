package com.tensions.cafembtitest.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface CafeMbtiMapper {
    void setMbtiResult(@Param("result") String result);

    float getMbtiPercent(@Param("result") String result);

    int getPeopleCount();

    // mbti 질문,답변 리스트 조회
    List<Map<String,String>> selectMbtiQuestion(String num);
}
