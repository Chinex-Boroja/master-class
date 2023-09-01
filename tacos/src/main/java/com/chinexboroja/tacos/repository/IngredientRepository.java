package com.chinexboroja.tacos.repository;

import com.chinexboroja.tacos.domain.Ingredient;

import java.util.Optional;

public interface IngredientRepository{

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
