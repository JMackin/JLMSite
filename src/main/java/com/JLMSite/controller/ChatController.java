package com.JLMSite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChatController {


    @GetMapping("/Chat")
    public String scheduleChat()
    {
        return "redirect:https://calendly.com/johnluthermackin/chat";
    }



}
