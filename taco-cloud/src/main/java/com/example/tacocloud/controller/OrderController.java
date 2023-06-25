package com.example.tacocloud.controller;

import com.example.tacocloud.dto.TacoOrderDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

/**
 * @author Zairov Aziz
 * @date 25.06.2023
 **/

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("tacoOrderDto")
public class OrderController {

    @GetMapping("/current")
    public String orderForm() {

        return "order-form";
    }

    @PostMapping
    public String processOrder(
            @ModelAttribute @Valid TacoOrderDto tacoOrderDto,
            Errors errors,
            SessionStatus sessionStatus
    ) {

        if (errors.hasErrors()) {
            return "order-form";
        }

        log.info("Order submitted: {}", tacoOrderDto);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
