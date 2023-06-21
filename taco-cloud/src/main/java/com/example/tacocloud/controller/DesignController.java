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
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignController {

    @ModelAttribute
    public void addIngredientsToModel(Model model) {

        List<IngredientDto> ingredients = Arrays.asList(
                new IngredientDto("FLTO", "Flour Tortilla", Type.WRAP),
                new IngredientDto("COTO", "Corn Tortilla", Type.WRAP),
                new IngredientDto("GRBF", "Ground Beef", Type.PROTEIN),
                new IngredientDto("CARN", "Carnitas", Type.PROTEIN),
                new IngredientDto("TMTO", "Diced Tomatoes", Type.VEGGIES),
                new IngredientDto("LETC", "Lettuce", Type.VEGGIES),
                new IngredientDto("CHED", "Cheddar", Type.CHEESE),
                new IngredientDto("JACK", "Monterrey Jack", Type.CHEESE),
                new IngredientDto("SLSA", "Salsa", Type.SAUCE),
                new IngredientDto("SRCR", "Sour Cream", Type.SAUCE)
        );

        Type[] types = IngredientDto.Type.values();
        for (Type type: types) {
            model.addAttribute(type.toString().toLowerCase(Locale.ROOT), filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrderDto order() {

        return new TacoOrderDto();
    }

    @ModelAttribute(name = "taco")
    public TacoDto taco() {

        return new TacoDto();
    }

    @GetMapping
    public String showDesignForm() {

        return "design";
    }

    private Iterable<IngredientDto> filterByType(List<IngredientDto> ingredients, Type type) {

        return ingredients
                .stream()
                .filter(ingredientDto -> ingredientDto.getType().equals(type))
                .collect(Collectors.toList());
    }
}
