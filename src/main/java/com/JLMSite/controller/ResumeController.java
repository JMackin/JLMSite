package com.JLMSite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {
    @GetMapping("/Resume")
    public String resume()
    {
        return "Resume";
    }

}
