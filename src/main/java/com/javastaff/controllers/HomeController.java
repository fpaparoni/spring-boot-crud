package com.javastaff.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Homepage controller.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    String index() {
        return "index";
    }

}
