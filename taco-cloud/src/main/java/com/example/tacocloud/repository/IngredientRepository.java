package com.example.tacocloud.repository;

import com.example.tacocloud.dto.IngredientDto;

import java.util.Optional;

/**
 * @author Zairov Aziz
 * @date 27.06.2023
 **/

public interface IngredientRepository {

    Iterable<IngredientDto> findAll();

    Optional<IngredientDto> findById(String id);

    IngredientDto save(IngredientDto ingredientDto);
}
