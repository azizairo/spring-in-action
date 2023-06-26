package com.example.tacocloud.repository.impl;

import com.example.tacocloud.dto.TacoOrderDto;
import com.example.tacocloud.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Zairov Aziz
 * @date 27.06.2023
 **/

@Repository
public class JdbcOrderRepository implements OrderRepository {

    private final JdbcOperations jdbcOperations;

    @Autowired
    public JdbcOrderRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    @Transactional
    public TacoOrderDto save(TacoOrderDto tacoOrderDto) {
        return null;
    }
}
