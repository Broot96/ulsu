package com.example.ulsu.makeroom.controller;

import com.example.ulsu.makeroom.responseDto.BrdHeaderInfoResponse;
import com.example.ulsu.service.BrdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("board")
@Log4j2
@RequiredArgsConstructor
public class MainController {

    private final BrdService brdService;

    @GetMapping("/main")
    public void main(Model model){

        List<BrdHeaderInfoResponse> brdHeaderList = brdService.getHeaderList();
        model.addAttribute("headerList", brdHeaderList);

    }

    @GetMapping("/register")
    public void register(){

    }
}
