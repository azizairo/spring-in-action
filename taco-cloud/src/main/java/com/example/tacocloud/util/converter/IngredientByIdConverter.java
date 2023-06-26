package com.example.tacocloud.util.converter;

import com.example.tacocloud.dto.IngredientDto;
import com.example.tacocloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Zairov Aziz
 * @date 25.06.2023
 **/

@Component
public class IngredientByIdConverter implements Converter<String, IngredientDto> {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientDto convert(String id) {

        return ingredientRepository.findById(id).orElse(null);
    }
}
