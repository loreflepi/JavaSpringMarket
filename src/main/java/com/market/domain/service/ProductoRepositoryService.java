package com.market.domain.service;

import com.market.domain.dto.Product;
import com.market.domain.repository.ProductRepository;
import com.market.persistence.crud.ProductoCrudRepository;
import com.market.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductoRepositoryService implements ProductRepository {
    ProductoCrudRepository productoCrudRepository;
    @Autowired
    public ProductoRepositoryService(ProductoCrudRepository productoCrudRepository) {
        this.productoCrudRepository = productoCrudRepository;
    }

    public List<Product> getAllProducts(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return getCollect(productos);
    }

    public List<Product> getProductByCategoria(int idCategoria){
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreDesc(idCategoria);
        return getCollect(productos);
    }

    public List<Product> getProductoOferta(int precioVenta){
        List<Producto> productos = productoCrudRepository.findByPrecioVentaLessThanOrderByPrecioVentaDesc(precioVenta);
        return getCollect(productos);
    }

    public List<Product> getTop10Products(){
        List<Producto> productos = productoCrudRepository.findTop10ByOrderByPrecioVentaDesc();
        return getCollect(productos);
    }

    public Optional<Product> getProductoId(int idProducto){
        Optional<Producto> producto = productoCrudRepository.findById(idProducto);
        return producto.map(value -> new Product(value));
    }

    public Product saveProducto(Producto producto){
        Producto productoAux = productoCrudRepository.save(producto);
        return new Product(productoAux);
    }

    public void deleteProducto(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }

    private List<Product> getCollect(List<Producto> productos) {
        return productos.stream().map(value -> new Product(value)).collect(Collectors.toList());
    }

}
