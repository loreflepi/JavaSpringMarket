package com.market.persistence.crud;

import com.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    public List<Producto> findByIdCategoriaOrderByNombreDesc(int idCategoria);
    public List<Producto> findByPrecioVentaLessThanOrderByPrecioVentaDesc(int precioVenta);
    public List<Producto> findTop10ByOrderByPrecioVentaDesc();
}
