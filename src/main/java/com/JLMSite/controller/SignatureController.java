package com.JLMSite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignatureController {
    @GetMapping("/PGP")
    public String resume()
    {
        return "JLMPgp.html";
    }

}
