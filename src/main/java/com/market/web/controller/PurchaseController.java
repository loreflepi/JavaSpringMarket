package com.market.web.controller;

import com.market.domain.dto.Purchase;
import com.market.domain.service.PurchaseRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {

    PurchaseRepositoryService purchaseRepositoryService;

    @Autowired
    public PurchaseController(PurchaseRepositoryService purchaseRepositoryService) {
        this.purchaseRepositoryService = purchaseRepositoryService;
    }

    @GetMapping(path = "/purchase")
    public ResponseEntity<List<Purchase>> getAllPurchase(){
        List<Purchase> allPurchase = purchaseRepositoryService.getAll();
        return ResponseEntity.ok().body(allPurchase);
    }

    @GetMapping(path = "/purchase/{idClient}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable String idClient){
        List<Purchase> allPurchase = purchaseRepositoryService.getByClient(idClient);
        return ResponseEntity.ok().body(allPurchase);
    }

    @PostMapping(path = "/purchase")
    public ResponseEntity<Purchase> savePurchase(@RequestBody Purchase purchase){
        Purchase newPurchase = purchaseRepositoryService.save(purchase);
        return ResponseEntity.ok().body(newPurchase);
    }
}
