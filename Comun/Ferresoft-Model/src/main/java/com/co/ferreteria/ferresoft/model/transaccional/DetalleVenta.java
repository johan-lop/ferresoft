package com.co.ferreteria.ferresoft.model.transaccional;

import com.co.ferreteria.ferresoft.model.maestros.Producto;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author johan
 */
@Entity
@Table(name = "detalle_venta", schema = "transaccional")
@NamedQueries({
    @NamedQuery(name = "DetalleVenta.findAll", query = "SELECT d FROM DetalleVenta d")})
public class DetalleVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    @OneToOne
    private Producto producto;
    
    @Column(name = "cantidad")
    private Integer cantidad;
    
    @Column(name = "aplica_iva")
    private Boolean aplicaIva;
    
    @Column(name = "iva_incluido")
    private Boolean ivaIncluido;
    
    @Column(name = "precio")
    private Integer precio;
    
    @Column(name = "total")
    private Double total;
    
    @JoinColumn(name = "venta_id", referencedColumnName = "id")
    @OneToOne
    private Venta ventaId;

    public DetalleVenta() {
    }

    public DetalleVenta(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
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

    public Boolean getIvaIncluido() {
        return ivaIncluido;
    }

    public void setIvaIncluido(Boolean ivaIncluido) {
        this.ivaIncluido = ivaIncluido;
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

    public void setTotal(Double total) {
        this.total = total;
    }

    public Venta getVentaId() {
        return ventaId;
    }

    public void setVentaId(Venta ventaId) {
        this.ventaId = ventaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVenta)) {
            return false;
        }
        DetalleVenta other = (DetalleVenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ferreteria.ferresoft.model.transaccional.DetalleVenta[ id=" + id + " ]";
    }

}
