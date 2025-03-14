package com.tensions.cafembtitest.controller;

import com.tensions.cafembtitest.dto.CafeMbtiDTO;
import com.tensions.cafembtitest.service.CafeMbtiService;
import com.tensions.cafembtitest.vo.request.RequestMbtiResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/api/v1")
public class CafeMbtiController {

    private final CafeMbtiService cafeMbtiService;

    @Autowired
    public CafeMbtiController(CafeMbtiService cafeMbtiService) {
        this.cafeMbtiService = cafeMbtiService;
    }

    @PostMapping("/result")
    public ResponseEntity<Map<String, Object>> mbtiResult(@RequestBody RequestMbtiResultVO requestMbtiResultVO) {
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

        // 응답 데이터를 JSON 형식으로 반환
        Map<String, Object> mbtiInfo = new HashMap<>();
        mbtiInfo.put("resultMbti", resultMbti);
        mbtiInfo.put("ratio", ratio);

        System.out.println("resultMbti!!!!!!!!!!!!!! : " + resultMbti);
        System.out.println("ratio!!!!!!!!!!!!!! : " + ratio);
        return ResponseEntity.ok(mbtiInfo);
    }

    @GetMapping("/getMbtiResult")
    public String getMbtiResult(Model model) {

        return "mbti_result_layout";
    }

    @GetMapping("/main")
    public String getPeopleCount(Model model) {
        int participants = cafeMbtiService.getPeopleCount();

        model.addAttribute("participants", participants);

        return "mbti_main";
    }


    @GetMapping("/test")
    public String getMbtiTest(Model model) {
        List<Map<String,String>> mbtiQuestion = cafeMbtiService.selectMbtiQuestion("1");

        System.out.println(mbtiQuestion);
        model.addAttribute("mbtiQuestion", mbtiQuestion);

        return "mbti_test";
    }

    @GetMapping("/getList")
    public ResponseEntity<List<Map<String, String>>> selectMbtiTestList(@RequestParam("testNum") String testNum) {
        List<Map<String,String>> mbtiQuestion = cafeMbtiService.selectMbtiQuestion(testNum);

        System.out.println(mbtiQuestion);
        return ResponseEntity.ok(mbtiQuestion);
    }

}
