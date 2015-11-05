package com.co.ferreteria.ferresoft.dto.transaccional;

import com.co.ferreteria.ferresoft.dto.maestro.ProductoDto;
import java.io.Serializable;

/**
 * Dto para la calse detalle venta.
 *
 * @author johan
 */
public class DetalleVentaDto implements Serializable {

    private Long id;
    
    private ProductoDto producto;
    
    private VentaDto venta;
    
    private Integer cantidad;
    
    private Boolean aplicaIva;
    
    private Integer precio;
    
    private Double total;
    
    private Boolean ivaIncluido;
    
    
    public DetalleVentaDto() {
    
    }
    
    public ProductoDto getProducto() {
        return producto;
    }

    public void setProducto(ProductoDto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getAplicaIva() {
        return aplicaIva;
    }

    public void setAplicaIva(Boolean aplicaIva) {
        this.aplicaIva = aplicaIva;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Double getTotal() {
        return total;
    }

    public Boolean getIvaIncluido() {
        return ivaIncluido;
    }

    public void setIvaIncluido(Boolean ivaIncluido) {
        this.ivaIncluido = ivaIncluido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VentaDto getVenta() {
        return venta;
    }

    public void setVenta(VentaDto venta) {
        this.venta = venta;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
   
}
