package com.chinexboroja.tacos.repository;

import com.chinexboroja.tacos.domain.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {

}
