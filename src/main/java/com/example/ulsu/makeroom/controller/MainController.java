package com.example.ulsu.makeroom.controller;

import com.example.ulsu.makeroom.requestDto.BrdFileSaveRequest;
import com.example.ulsu.makeroom.requestDto.BrdLineSaveRequest;
import com.example.ulsu.makeroom.requestDto.BrdPageRequest;
import com.example.ulsu.makeroom.responseDto.BrdHeaderInfoResponse;
import com.example.ulsu.makeroom.responseDto.BrdLineInfoResponse;
import com.example.ulsu.makeroom.responseDto.BrdPageResponse;
import com.example.ulsu.service.BrdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("board")
@Log4j2
@RequiredArgsConstructor
public class MainController {

    private final BrdService brdService;

    @GetMapping("/main")
    public void main(Model model, BrdPageRequest brdPageRequest){

        List<BrdHeaderInfoResponse> brdHeaderList = brdService.getHeaderList();
        BrdPageResponse<BrdLineInfoResponse> pageResponse = brdService.list(brdPageRequest);

        model.addAttribute("headerList", brdHeaderList);
        model.addAttribute("pageResponse", pageResponse);

    }

    @GetMapping("/register")
    public void register(Model model){
        log.info("+++++ 작성 들어옴 +++++");


    }

    @PostMapping("/register")
    public String registerSave(Model model, BrdLineSaveRequest brdLineSaveRequest,@RequestParam("formFile")    MultipartFile[] uploadFile){


        BrdFileSaveRequest fileSaveRequest = new BrdFileSaveRequest();
        fileSaveRequest.setUploadFile(uploadFile);
        fileSaveRequest.setBrdLineSeq(brdLineSaveRequest.getBrdLineSeq());

        Long brdLineSeq = brdService.LineSave(brdLineSaveRequest);
        fileSaveRequest.setBrdLineSeq(brdLineSeq);

        brdService.FileSave(fileSaveRequest);



        return "redirect:/board/main";

    }
    @GetMapping("/read")
    public void read(Model model){

    }
    @GetMapping("/lte3")
    public void lte(Model model){
        log.info("+++++++lte 들어옴+++++++++");
        List<BrdHeaderInfoResponse> brdHeaderList = brdService.getHeaderList();


        model.addAttribute("headerList", brdHeaderList);
    }
}
