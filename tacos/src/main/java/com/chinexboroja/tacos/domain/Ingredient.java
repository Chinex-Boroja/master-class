package com.chinexboroja.tacos.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
//@Table("ingredients") // Cassandra mapping to Table
@Document(collection = "ingredients") // Mongo
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient {

//    @PrimaryKey
    @Id
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE
    }
}
