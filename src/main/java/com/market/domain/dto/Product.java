package com.market.domain.dto;

import com.market.persistence.entity.Producto;

public class Product {
    private Integer idProducto;

    private String nombre;

    private Integer idCategoria;

    private String codigoBarras;

    private Integer precioVenta;

    private Integer cantidadStock;

    private Boolean estado;

    public Product(Integer idProducto, String nombre, Integer idCategoria, String codigoBarras, Integer precioVenta, Integer cantidadStock, Boolean estado) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.idCategoria = idCategoria;
        this.codigoBarras = codigoBarras;
        this.precioVenta = precioVenta;
        this.cantidadStock = cantidadStock;
        this.estado = estado;
    }

    public Product(Producto producto){
        this.idProducto = producto.getIdProducto();
        this.nombre = producto.getNombre();
        this.idCategoria = producto.getIdCategoria();
        this.codigoBarras = producto.getCodigoBarras();
        this.precioVenta = producto.getPrecioVenta();
        this.cantidadStock = producto.getCantidadStock();
        this.estado = producto.getEstado();
    }


    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Integer getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Integer precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
