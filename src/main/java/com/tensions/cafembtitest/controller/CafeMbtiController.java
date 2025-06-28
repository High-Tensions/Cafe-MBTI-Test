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
@RequestMapping("")
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

        return ResponseEntity.ok(mbtiInfo);
    }

    @GetMapping("/getMbtiResult")
    public String getMbtiResult(Model model) {

        return "mbti_result_layout";
    }

    @GetMapping("/")
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

    @GetMapping("/loading")
    public String getLoading() {
        return "mbti_loading";
    }

    @GetMapping("/getList")
    public ResponseEntity<List<Map<String, String>>> selectMbtiTestList(@RequestParam("testNum") String testNum) {
        List<Map<String,String>> mbtiQuestion = cafeMbtiService.selectMbtiQuestion(testNum);

        System.out.println(mbtiQuestion);
        return ResponseEntity.ok(mbtiQuestion);
    }

    // mbti 결과페이지
    @GetMapping("/INTJ")
    public String getINTJ(Model model) {
        float ratio = cafeMbtiService.mbtiPercent("INTJ");
        model.addAttribute("ratio", ratio);
        return "mbti/INTJ";
    }

    @GetMapping("/INTP")
    public String getINTP(Model model) {
        float ratio = cafeMbtiService.mbtiPercent("INTP");
        model.addAttribute("ratio", ratio);
        return "mbti/INTP";
    }

    @GetMapping("/ENTJ")
    public String getENTJ(Model model) {
        float ratio = cafeMbtiService.mbtiPercent("ENTJ");
        model.addAttribute("ratio", ratio);
        return "mbti/ENTJ";
    }

    @GetMapping("/ENTP")
    public String getENTP(Model model) {
        float ratio = cafeMbtiService.mbtiPercent("ENTP");
        model.addAttribute("ratio", ratio);
        return "mbti/ENTP";
    }

    @GetMapping("/INFJ")
    public String getINFJ(Model model) {
        float ratio = cafeMbtiService.mbtiPercent("INFJ");
        model.addAttribute("ratio", ratio);
        return "mbti/INFJ";
    }

    @GetMapping("/INFP")
    public String getINFP(Model model) {
        float ratio = cafeMbtiService.mbtiPercent("INFP");
        model.addAttribute("ratio", ratio);
        return "mbti/INFP";
    }

    @GetMapping("/ENFJ")
    public String getENFJ(Model model) {
        float ratio = cafeMbtiService.mbtiPercent("ENFJ");
        model.addAttribute("ratio", ratio);
        return "mbti/ENFJ";
    }

    @GetMapping("/ENFP")
    public String getENFP(Model model) {
        float ratio = cafeMbtiService.mbtiPercent("ENFP");
        model.addAttribute("ratio", ratio);
        return "mbti/ENFP";
    }

    @GetMapping("/ISTJ")
    public String getISTJ(Model model) {
        float ratio = cafeMbtiService.mbtiPercent("ISTJ");
        model.addAttribute("ratio", ratio);
        return "mbti/ISTJ";
    }

    @GetMapping("/ISFJ")
    public String getISFJ(Model model) {
        float ratio = cafeMbtiService.mbtiPercent("ISFJ");
        model.addAttribute("ratio", ratio);
        return "mbti/ISFJ";
    }

    @GetMapping("/ESFJ")
    public String getESFJ(Model model) {
        float ratio = cafeMbtiService.mbtiPercent("ESFJ");
        model.addAttribute("ratio", ratio);
        return "mbti/ESFJ";
    }

    @GetMapping("/ISTP")
    public String getISTP(Model model) {
        float ratio = cafeMbtiService.mbtiPercent("ISTP");
        model.addAttribute("ratio", ratio);
        return "mbti/ISTP";
    }

    @GetMapping("/ISFP")
    public String getISFP(Model model) {
        float ratio = cafeMbtiService.mbtiPercent("ISFP");
        model.addAttribute("ratio", ratio);
        return "mbti/ISFP";
    }

    @GetMapping("/ESTP")
    public String getESTP(Model model) {
        float ratio = cafeMbtiService.mbtiPercent("ESTP");
        model.addAttribute("ratio", ratio);
        return "mbti/ESTP";
    }

    @GetMapping("/ESFP")
    public String getESFP(Model model) {
        float ratio = cafeMbtiService.mbtiPercent("ESFP");
        model.addAttribute("ratio", ratio);
        return "mbti/ESFP";
    }

    @GetMapping("/ESTJ")
    public String getESTJ(Model model) {
        float ratio = cafeMbtiService.mbtiPercent("ESTJ");
        model.addAttribute("ratio", ratio);
        return "mbti/ESTJ";
    }

}
