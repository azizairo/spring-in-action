package com.example.tacocloud.dto;

/*
 * Date:    21.06.2023
 * @author  zairov_43054
 * @version 1.0
 *
 */

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class TacoDto {

    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<IngredientDto> ingredients;
}
