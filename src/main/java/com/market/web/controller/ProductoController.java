package com.market.web.controller;

import com.market.domain.dto.Product;
import com.market.domain.service.ProductoRepositoryService;
import com.market.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductoController {

    ProductoRepositoryService productoRepositoryService;
    @Autowired
    public ProductoController(ProductoRepositoryService productoRepositoryService) {
        this.productoRepositoryService = productoRepositoryService;
    }

    @GetMapping(path = "/producto")
    public List<Product> getAllProducts(){
        return productoRepositoryService.getAllProducts();
    }

    @GetMapping(path = "/producto/categoria/{idCategoria}")
    public List<Product> getAllProductsByCategoria(@PathVariable int idCategoria){
        return productoRepositoryService.getProductByCategoria(idCategoria);
    }

    @GetMapping(path = "/producto/oferta/{precioVenta}")
    public List<Product> getAllProductsOferta(@PathVariable int precioVenta){
        return productoRepositoryService.getProductoOferta(precioVenta);
    }

    @GetMapping(path = "/producto/hipster")
    public List<Product> getAllProductsHipster(){
        return productoRepositoryService.getTop10Products();
    }

    @GetMapping(path = "/producto/{idProducto}")
    public ResponseEntity<Product> getproductoById(@PathVariable int idProducto){
        Optional<Product> producto = productoRepositoryService.getProductoId(idProducto);
        if(producto.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(producto.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PostMapping(path = "/producto")
    public ResponseEntity<Product> saveProduct(@RequestBody Producto producto){
        producto.setIdProducto(null);
        Product auxiliar = productoRepositoryService.saveProducto(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(auxiliar);
    }

    @DeleteMapping(path = "/producto/{idProducto}")
    public ResponseEntity<Product> saveProduct(@PathVariable int idProducto){
        Optional<Product> producto = productoRepositoryService.getProductoId(idProducto);
        if(producto.isPresent()){
            productoRepositoryService.deleteProducto(idProducto);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

    }
}
