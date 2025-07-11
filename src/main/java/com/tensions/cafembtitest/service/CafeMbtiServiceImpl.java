package com.tensions.cafembtitest.service;

import com.tensions.cafembtitest.dto.CafeMbtiDTO;
import com.tensions.cafembtitest.repository.CafeMbtiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CafeMbtiServiceImpl implements CafeMbtiService {

    private final CafeMbtiMapper cafeMbtiMapper;

    @Autowired
    public CafeMbtiServiceImpl(CafeMbtiMapper cafeMbtiMapper) {
        this.cafeMbtiMapper = cafeMbtiMapper;
    }

    @Override
    public String mbtiResult(CafeMbtiDTO cafeMbtiDTO) {
        String result;
        if (cafeMbtiDTO.getE() > cafeMbtiDTO.getI()) result = "E";
        else result = "I";
        if (cafeMbtiDTO.getN() > cafeMbtiDTO.getS()) result += "N";
        else result += "S";
        if (cafeMbtiDTO.getT() > cafeMbtiDTO.getF()) result += "T";
        else result += "F";
        if (cafeMbtiDTO.getP() > cafeMbtiDTO.getJ()) result += "P";
        else result += "J";

        cafeMbtiMapper.setMbtiResult(result);

        return result;
    }

    @Override
    public float mbtiPercent(String result) {
        float percent = cafeMbtiMapper.getMbtiPercent(result);

        return percent;
    }

    @Override
    public int getPeopleCount() {
        int ratio = cafeMbtiMapper.getPeopleCount();
        return ratio;
    }

    // mbti 질문,답변 리스트 조회
    @Override
    public List<Map<String,String>> selectMbtiQuestion(String num) {
        return cafeMbtiMapper.selectMbtiQuestion(num);
    }
}
