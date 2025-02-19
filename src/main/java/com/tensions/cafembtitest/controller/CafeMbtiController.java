package com.tensions.cafembtitest.controller;

import com.tensions.cafembtitest.dto.CafeMbtiDTO;
import com.tensions.cafembtitest.service.CafeMbtiService;
import com.tensions.cafembtitest.vo.request.RequestMbtiResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/result")
public class CafeMbtiController {

    private final CafeMbtiService cafeMbtiService;

    @Autowired
    public CafeMbtiController(CafeMbtiService cafeMbtiService) {
        this.cafeMbtiService = cafeMbtiService;
    }

    @PostMapping("/mbti")
    public String mbtiResult(@RequestBody RequestMbtiResultVO requestMbtiResultVO) {
        CafeMbtiDTO cafeMbtiDTO = new CafeMbtiDTO();
        cafeMbtiDTO.setE(requestMbtiResultVO.getE());
        cafeMbtiDTO.setI(requestMbtiResultVO.getI());
        cafeMbtiDTO.setN(requestMbtiResultVO.getN());
        cafeMbtiDTO.setS(requestMbtiResultVO.getS());
        cafeMbtiDTO.setT(requestMbtiResultVO.getT());
        cafeMbtiDTO.setF(requestMbtiResultVO.getF());
        cafeMbtiDTO.setP(requestMbtiResultVO.getP());
        cafeMbtiDTO.setJ(requestMbtiResultVO.getJ());

        String result = cafeMbtiService.mbtiResult(cafeMbtiDTO);
        float percent = cafeMbtiService.mbtiPercent(result);

        System.out.println("percent: " + percent);

        return result;
    }

}
