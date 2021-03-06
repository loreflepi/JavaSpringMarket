package com.market.persistence.crud;

import com.market.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
    List<Compra> findByidCliente(String idCliente);
}
