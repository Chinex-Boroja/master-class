package com.chinexboroja.tacos.domain;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@UserDefinedType("ingredients")
public class IngredientUDT {

    private final String name;

    private final Ingredient.Type type;

}
