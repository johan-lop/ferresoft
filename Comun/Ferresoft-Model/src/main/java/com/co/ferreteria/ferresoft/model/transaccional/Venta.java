package com.co.ferreteria.ferresoft.model.transaccional;

import com.co.ferreteria.ferresoft.model.maestros.Cliente;
import com.co.ferreteria.ferresoft.model.maestros.TipoPago;
import com.co.ferreteria.ferresoft.model.maestros.TipoVenta;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author johan
 */
@Entity
@Table(name = "venta", schema = "transaccional")
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v")})
public class Venta implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "numero_remision")
    private Integer numeroRemision;
    
    @Column(name = "numero_factura")
    private Integer numeroFactura;
    
    @Column(name = "aplica_iva")
    private Boolean aplicaIva;
    
    @Column(name = "subtotal")
    private Double subtotal;
    
    @Column(name = "total_iva")
    private Double totalIva;
    
    @Column(name = "total")
    private Double total;
    
    @Column(name = "fecha_factura")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFactura;
    
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    @OneToOne
    private Cliente cliente;
    
    @OneToMany(mappedBy = "ventaId")
    private List<DetalleVenta> detalleVentaList;

    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaVencimiento;
    
    @JoinColumn(name = "tipo_venta_id", referencedColumnName = "id")
    @OneToOne
    private TipoVenta tipoVenta;
    
    @JoinColumn(name = "tipo_pago_id", referencedColumnName = "id")
    @OneToOne
    private TipoPago tipoPago;
    
    @Column(name = "total_importe")
    private Double totalImporte;
    
    public Venta() {
    }

    public Venta(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public Integer getNumeroRemision() {
        return numeroRemision;
    }

    public void setNumeroRemision(Integer numeroRemision) {
        this.numeroRemision = numeroRemision;
    }

    public Integer getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Integer numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Boolean getAplicaIva() {
        return aplicaIva;
    }

    public void setAplicaIva(Boolean aplicaIva) {
        this.aplicaIva = aplicaIva;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(Double totalIva) {
        this.totalIva = totalIva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Cliente getClienteId() {
        return cliente;
    }

    public void setClienteId(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public TipoVenta getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(TipoVenta tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Double getTotalImporte() {
        return totalImporte;
    }

    public void setTotalImporte(Double totalImporte) {
        this.totalImporte = totalImporte;
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
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ferreteria.ferresoft.model.transaccional.Venta[ id=" + id + " ]";
    }
    
}
