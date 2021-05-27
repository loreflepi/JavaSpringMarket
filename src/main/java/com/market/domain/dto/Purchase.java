package com.market.domain.dto;
import com.market.persistence.entity.Compra;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class Purchase {
    private Integer idPurchase;
    private String idClient;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;
    private List<PurchaseItem> boughtProducts;

    public Purchase() {
    }

    public Purchase(Integer idPurchase, String idClient, LocalDateTime date, String paymentMethod, String comment,
                    String state, List<PurchaseItem> boughtProducts) {
        this.idPurchase = idPurchase;
        this.idClient = idClient;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.comment = comment;
        this.state = state;
        this.boughtProducts = boughtProducts;
    }

    public Purchase(Compra compra) {
        this.idPurchase = compra.getIdCompra();
        this.idClient = compra.getIdCliente();
        this.date = compra.getFecha();
        this.paymentMethod = compra.getMedioPago();
        this.comment = compra.getComentario();
        this.state = compra.getEstado();
        if(compra.getComprasProductos() != null) {
            this.boughtProducts = compra.getComprasProductos().stream().map(PurchaseItem::new).
                    collect(Collectors.toList());
        }
    }

    public Integer getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Integer idPurchase) {
        this.idPurchase = idPurchase;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<PurchaseItem> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(List<PurchaseItem> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }
}
