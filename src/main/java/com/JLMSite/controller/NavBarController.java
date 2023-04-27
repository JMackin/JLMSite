package com.JLMSite.controller;

import com.JLMSite.model.JLMUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NavBarController {

    @GetMapping("navbar")
    public String makeNavBar(Model model){

        String userName;
        boolean isAuthed;
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Object principal = auth.getPrincipal();

        //TODO use .isAnonymous() function instead
        if (!principal.toString().equals("anonymousUser")) {
            JLMUserDetails jlmUserDetails = (JLMUserDetails) principal;
            userName = jlmUserDetails.getUsername();
            isAuthed = true;
        }else {
           userName = "visitor";
           isAuthed = false;
        }
        model.addAttribute("User", userName);
        model.addAttribute("isauthed", isAuthed);

        return "fragments/header";

    }


}
