package com.market.persistence.entity;

import com.market.domain.dto.PurchaseItem;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {
    @EmbeddedId
    private ComprasProductoPK id;
    private Integer cantidad;
    private BigDecimal total;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;

    public ComprasProducto() {
    }

    public ComprasProducto(ComprasProductoPK id, Integer cantidad, BigDecimal total, Boolean estado, Producto producto,
                           Compra compra) {
        this.id = id;
        this.cantidad = cantidad;
        this.total = total;
        this.estado = estado;
        this.producto = producto;
        this.compra = compra;
    }

    public ComprasProducto(PurchaseItem purchaseItem) {
        this.id = new ComprasProductoPK(purchaseItem.getIdProduct(), purchaseItem.getIdPurchase());
        this.cantidad = purchaseItem.getQuantity();
        this.total = purchaseItem.getTotal();
        this.estado = purchaseItem.getState();
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ComprasProductoPK getId() {
        return id;
    }

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
