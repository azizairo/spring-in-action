package com.example.tacocloud.dto;

/*
 * Date:    21.06.2023
 * @author  zairov_43054
 * @version 1.0
 *
 */

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TacoOrderDto {

    private String deliveryName;
    private String deliveryStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;

    private List<TacoDto> tacos = new ArrayList<>();

    public void addTaco(TacoDto tacoDto) {

        this.tacos.add(tacoDto);
    }
}
