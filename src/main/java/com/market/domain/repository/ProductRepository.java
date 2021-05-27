package com.market.domain.repository;

import com.market.domain.dto.Product;
import com.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    public List<Product> getAllProducts();

    public List<Product> getProductByCategoria(int idCategoria);

    public List<Product> getProductoOferta(int precioVenta);

    public List<Product> getTop10Products();

    public Optional<Product> getProductoId(int idProducto);

    public Product saveProducto(Producto producto);

    public void deleteProducto(int idProducto);
}
