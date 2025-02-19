package com.tensions.cafembtitest.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CafeMbtiMapper {
    void setMbtiResult(@Param("result") String result);

    float getMbtiPercent(@Param("result") String result);
}
