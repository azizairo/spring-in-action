package com.example.tacocloud.controller;

/*
 * Date:    07.06.2023
 * @author  zairov_43054
 * @version 1.0
 *
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {

        return "home";
    }
}
