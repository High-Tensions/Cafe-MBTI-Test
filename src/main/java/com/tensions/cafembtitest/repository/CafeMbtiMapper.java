package com.tensions.cafembtitest.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CafeMbtiMapper {
    void setMbtiResult(String result);
}
