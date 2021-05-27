package com.market.domain.repository;

import com.market.domain.dto.Purchase;

import java.util.List;

public interface PurchaseRepository {
    List<Purchase> getAll();
    List<Purchase> getByClient(String clientId);
    Purchase save(Purchase purchase);
}
