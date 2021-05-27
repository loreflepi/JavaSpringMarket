package com.market.persistence.entity;

import com.market.domain.dto.Purchase;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "compras")
public class Compra {
    @Id
    @Column(name="id_compra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompra;

    @Column(name="id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    @Column(name="medio_pago")
    private String medioPago;

    private String comentario;

    private String estado;

    @OneToMany(mappedBy = "compra")
    private List<ComprasProducto> comprasProductos;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;

    public Compra() {
    }

    public Compra(Integer idCompra, String idCliente, LocalDateTime fecha, String medioPago, String comentario,
                  String estado, List<ComprasProducto> comprasProductos, Cliente cliente) {
        this.idCompra = idCompra;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.medioPago = medioPago;
        this.comentario = comentario;
        this.estado = estado;
        this.comprasProductos = comprasProductos;
        this.cliente = cliente;
    }

    public Compra(Purchase purchase) {
        this.idCompra = purchase.getIdPurchase();
        this.idCliente = purchase.getIdClient();
        this.fecha = purchase.getDate();
        this.medioPago = purchase.getPaymentMethod();
        this.comentario = purchase.getComment();
        this.estado = purchase.getState();
        if(purchase.getBoughtProducts() != null){
            this.comprasProductos = purchase.getBoughtProducts().stream().map(ComprasProducto::new).
                    collect(Collectors.toList());
        }
    }

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<ComprasProducto> getComprasProductos() {
        return comprasProductos;
    }

    public void setComprasProductos(List<ComprasProducto> comprasProductos) {
        this.comprasProductos = comprasProductos;
    }
}
