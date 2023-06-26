package com.example.tacocloud.controller;

/*
 * Date:    21.06.2023
 * @author  zairov_43054
 * @version 1.0
 *
 */

import com.example.tacocloud.dto.IngredientDto;
import com.example.tacocloud.dto.IngredientDto.Type;
import com.example.tacocloud.dto.TacoDto;
import com.example.tacocloud.dto.TacoOrderDto;
import com.example.tacocloud.repository.IngredientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrderDto")
public class DesignController {


    private final IngredientRepository ingredientRepository;

    @Autowired
    public DesignController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) {

        Iterable<IngredientDto> ingredients = ingredientRepository.findAll();
        Type[] types = IngredientDto.Type.values();
        for (Type type: types) {
            model.addAttribute(type.toString().toLowerCase(Locale.ROOT), filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrderDto")
    public TacoOrderDto order() {

        return new TacoOrderDto();
    }

    @ModelAttribute(name = "tacoDto")
    public TacoDto taco() {

        return new TacoDto();
    }

    @GetMapping
    public String showDesignForm() {

        return "design";
    }

    @PostMapping
    public String processTaco(@Valid TacoDto tacoDto, Errors errors, @ModelAttribute TacoOrderDto tacoOrderDto) {

        if (errors.hasErrors()) {
            return "design";
        }

        tacoOrderDto.addTaco(tacoDto);
        log.info("Processing taco: {}", tacoDto);

        return "redirect:/orders/current";
    }

    private Iterable<IngredientDto> filterByType(Iterable<IngredientDto> ingredients, Type type) {

        return StreamSupport.stream(ingredients.spliterator(), false)
                .filter(ingredientDto -> ingredientDto.getType().equals(type))
                .collect(Collectors.toList());
    }
}
