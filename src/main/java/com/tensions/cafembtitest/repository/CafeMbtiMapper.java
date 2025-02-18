package com.tensions.cafembtitest.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CafeMbtiMapper {
    void setMbtiResult(@Param("result") String result);

    int getMbtiPercent(@Param("result") String result);
}
