package com.example.tacocloud.util.converter;

import com.example.tacocloud.dto.IngredientDto;
import com.example.tacocloud.dto.IngredientDto.Type;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zairov Aziz
 * @date 25.06.2023
 **/

@Component
public class IngredientByIdConverter implements Converter<String, IngredientDto> {

    private Map<String, IngredientDto> ingredientDtoMap = new HashMap<>();

    public IngredientByIdConverter() {

        ingredientDtoMap.put("FLTO", new IngredientDto("FLTO", "Flour Tortilla", Type.WRAP));
        ingredientDtoMap.put("COTO", new IngredientDto("COTO", "Corn Tortilla", Type.WRAP));
        ingredientDtoMap.put("GRBF", new IngredientDto("GRBF", "Ground Beef", Type.PROTEIN));
        ingredientDtoMap.put("CARN", new IngredientDto("CARN", "Carnitas", Type.PROTEIN));
        ingredientDtoMap.put("TMTO", new IngredientDto("TMTO", "Diced Tomatoes", Type.VEGGIES));
        ingredientDtoMap.put("LETC", new IngredientDto("LETC", "Lettuce", Type.VEGGIES));
        ingredientDtoMap.put("CHED", new IngredientDto("CHED", "Cheddar", Type.CHEESE));
        ingredientDtoMap.put("JACK", new IngredientDto("JACK", "Monterrey Jack", Type.CHEESE));
        ingredientDtoMap.put("SLSA", new IngredientDto("SLSA", "Salsa", Type.SAUCE));
        ingredientDtoMap.put("SRCR", new IngredientDto("SRCR", "Sour Cream", Type.SAUCE));
    }

    @Override
    public IngredientDto convert(String id) {
        return ingredientDtoMap.get(id);
    }
}
