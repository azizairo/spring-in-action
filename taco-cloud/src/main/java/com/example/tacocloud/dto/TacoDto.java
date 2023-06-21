package com.example.tacocloud.dto;

/*
 * Date:    21.06.2023
 * @author  zairov_43054
 * @version 1.0
 *
 */

import lombok.Data;

import java.util.List;

@Data
public class TacoDto {

    private String name;
    private List<IngredientDto> ingredients;
}
