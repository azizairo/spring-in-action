package com.example.tacocloud.dto;

/*
 * Date:    21.06.2023
 * @author  zairov_43054
 * @version 1.0
 *
 */

import lombok.Data;

@Data
public class IngredientDto {

    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
