package com.tensions.cafembtitest.controller;

import com.tensions.cafembtitest.dto.CafeMbtiDTO;
import com.tensions.cafembtitest.service.CafeMbtiService;
import com.tensions.cafembtitest.vo.request.RequestMbtiResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
public class CafeMbtiController {

    private final CafeMbtiService cafeMbtiService;

    @Autowired
    public CafeMbtiController(CafeMbtiService cafeMbtiService) {
        this.cafeMbtiService = cafeMbtiService;
    }

    @PostMapping("/result")
    public String mbtiResult(@RequestBody RequestMbtiResultVO requestMbtiResultVO, Model model) {
        CafeMbtiDTO cafeMbtiDTO = new CafeMbtiDTO();
        cafeMbtiDTO.setE(requestMbtiResultVO.getE());
        cafeMbtiDTO.setI(requestMbtiResultVO.getI());
        cafeMbtiDTO.setN(requestMbtiResultVO.getN());
        cafeMbtiDTO.setS(requestMbtiResultVO.getS());
        cafeMbtiDTO.setT(requestMbtiResultVO.getT());
        cafeMbtiDTO.setF(requestMbtiResultVO.getF());
        cafeMbtiDTO.setP(requestMbtiResultVO.getP());
        cafeMbtiDTO.setJ(requestMbtiResultVO.getJ());

        String resultMbti = cafeMbtiService.mbtiResult(cafeMbtiDTO);
        float ratio = cafeMbtiService.mbtiPercent(resultMbti);

        model.addAttribute("resultMbti", resultMbti);
        model.addAttribute("ratio", ratio);

        return "mbti_result_layout";
    }

    @GetMapping("/main")
    public String getPeopleCount(Model model) {
        int participants = cafeMbtiService.getPeopleCount();

        model.addAttribute("participants", participants);

        return "mbti_main";
    }

    @GetMapping("/test")
    public String getMbtiTest() {
        return "mbti_test";
    }

}
