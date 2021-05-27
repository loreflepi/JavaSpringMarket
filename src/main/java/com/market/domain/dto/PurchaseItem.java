package com.market.domain.dto;

import com.market.persistence.entity.ComprasProducto;

import java.math.BigDecimal;

public class PurchaseItem {
    private Integer idPurchase;
    private Integer idProduct;
    private Integer quantity;
    private BigDecimal total;
    private Boolean state;

    public PurchaseItem() {
    }

    public PurchaseItem(Integer idPurchase, Integer idProduct, Integer quantity, BigDecimal total, Boolean state) {
        this.idPurchase = idPurchase;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.total = total;
        this.state = state;
    }

    public PurchaseItem(ComprasProducto comprasProducto) {
        this.idPurchase = comprasProducto.getId().getIdCompra();
        this.idProduct = comprasProducto.getId().getIdProducto();
        this.quantity = comprasProducto.getCantidad();
        this.total = comprasProducto.getTotal();
        this.state = comprasProducto.getEstado();
    }

    public Integer getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(Integer idPurchase) {
        this.idPurchase = idPurchase;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
