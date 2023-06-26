package com.example.tacocloud.repository.impl;

import com.example.tacocloud.dto.IngredientDto;
import com.example.tacocloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * @author Zairov Aziz
 * @date 27.06.2023
 **/

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<IngredientDto> findAll() {

        return jdbcTemplate.query(
                "select id, name, type from Ingredient",
                this::mapRowToIngredientDto
        );
    }

    @Override
    public Optional<IngredientDto> findById(String id) {

        List<IngredientDto> results = jdbcTemplate.query(
                "select id, name, type from Ingredient where id=?",
                this::mapRowToIngredientDto,
                id
        );
        return results.size() == 0 ?
                Optional.empty() :
                Optional.of(results.get(0));
    }

    @Override
    public IngredientDto save(IngredientDto ingredientDto) {

        jdbcTemplate.update("" +
                "insert into Ingredients (id, name, type) values (?, ?, ?)",
                ingredientDto.getId(),
                ingredientDto.getName(),
                ingredientDto.getType().toString()
        );
        return ingredientDto;
    }

    private IngredientDto mapRowToIngredientDto(ResultSet row, int rowNum) throws SQLException {

        return new IngredientDto(
                row.getString("id"),
                row.getString("name"),
                IngredientDto.Type.valueOf(row.getString("type"))
        );
    }
}
