package com.ruiyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @RequestMapping(value = "/index")
    public String index() {
        return "/student/index";
    }
}

