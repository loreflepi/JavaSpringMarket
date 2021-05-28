package com.market.domain.service;

import com.market.domain.dto.Purchase;
import com.market.domain.repository.PurchaseRepository;
import com.market.persistence.crud.CompraCrudRepository;
import com.market.persistence.crud.ComprasProductoCrudRepository;
import com.market.persistence.entity.Compra;
import com.market.persistence.entity.ComprasProducto;
import com.market.persistence.entity.ComprasProductoPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PurchaseRepositoryService implements PurchaseRepository {
    CompraCrudRepository compraCrudRepository;
    ComprasProductoCrudRepository comprasProductoCrudRepository;

    @Autowired
    public PurchaseRepositoryService(CompraCrudRepository compraCrudRepository,
                                     ComprasProductoCrudRepository comprasProductoCrudRepository) {
        this.compraCrudRepository = compraCrudRepository;
        this.comprasProductoCrudRepository = comprasProductoCrudRepository;
    }

    @Override
    public List<Purchase> getAll() {
        List<Compra> compras = (List<Compra>) compraCrudRepository.findAll();
        return getCollect(compras);
    }

    @Override
    public List<Purchase> getByClient(String clientId) {
        List<Compra> compras = compraCrudRepository.findByidCliente(clientId);
        return getCollect(compras);
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = new Compra(purchase);
        if (compra.getComprasProductos() != null) {
            compra.getComprasProductos().forEach(value -> value.setCompra(compra));
        }
        compraCrudRepository.save(compra);
        return new Purchase(compra);
    }

    private List<Purchase> getCollect(List<Compra> compras) {
        return compras.stream().map(Purchase::new).collect(Collectors.toList());
    }
}
