package com.progeny.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreateGroupController {

    @GetMapping("/group/create")
    public String index() {
        return "createGroup";
    }

}
