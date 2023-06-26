package com.example.tacocloud.repository;

import com.example.tacocloud.dto.TacoOrderDto;

/**
 * @author Zairov Aziz
 * @date 27.06.2023
 **/

public interface OrderRepository {

    TacoOrderDto save(TacoOrderDto tacoOrderDto);
}
