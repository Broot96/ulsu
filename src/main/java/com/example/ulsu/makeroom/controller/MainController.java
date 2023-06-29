package com.example.ulsu.makeroom.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class MainController {

    @GetMapping("/board/main")
    public void main(){

    }

    @GetMapping("/board/register")
    public void register(){

    }
}
