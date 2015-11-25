package com.co.ferreteria.ferresoft.model.maestros;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author johan
 */
@Entity
@Table(schema = "maestro", name = "producto")
@NamedQueries({
    @NamedQuery(name = "Producto.findLikeDescripcion",
            query = "SELECT NEW com.co.ferreteria.ferresoft.dto.maestro.ProductoDto(p.id, p.descripcion, "
            + "p.precio, p.costo, p.stock, m.descripcion, u.descripcion) "
            + "FROM Producto p JOIN p.unidadId u JOIN p.marcaId m "
            + "WHERE UPPER(p.descripcion) LIKE :descripcion"),
    @NamedQuery(name = "Producto.updateById", query = "UPDATE Producto p set p.descripcion = :descripcion, "
            + "p.precio = :precio, p.costo = :costo, p.stock = :stock, p.marcaId.id = :marcaId, "
            + "p.unidadId.id = :unidadId WHERE id = :id"),
    @NamedQuery(name = "Producto.updateStockById", query = "UPDATE Producto p set p.stock = :stock  WHERE p.id = :id"),
    @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p  WHERE p.id = :id")
})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "precio")
    private Integer precio;

    @Column(name = "costo")
    private Integer costo;

    @Column(name = "stock")
    private Integer stock;

    @JoinColumn(name = "marca_id", referencedColumnName = "id")
    @ManyToOne
    private Marca marcaId;

    @JoinColumn(name = "unidad_id", referencedColumnName = "id")
    @ManyToOne
    private Unidad unidadId;

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Marca getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Marca marcaId) {
        this.marcaId = marcaId;
    }

    public Unidad getUnidadId() {
        return unidadId;
    }

    public void setUnidadId(Unidad unidadId) {
        this.unidadId = unidadId;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ferreteria.ferresoft.model.maestros.Producto[ id=" + id + " ]";
    }

}
