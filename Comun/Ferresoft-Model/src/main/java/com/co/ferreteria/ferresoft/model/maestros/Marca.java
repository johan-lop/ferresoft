package com.co.ferreteria.ferresoft.model.maestros;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author johan
 */
@Entity
@Table(schema = "maestro", name = "marca")
@NamedQueries({
    @NamedQuery(name = "Marca.findAll", query = "SELECT NEW com.co.ferreteria.ferresoft.dto.maestro.MarcaDto"
            + "(m.id, m.descripcion) FROM Marca m"),
    @NamedQuery(name = "Marca.findById", query = "SELECT m FROM Marca m WHERE m.id = :id"),
    @NamedQuery(name = "Marca.findByDescripcion", query = "SELECT m FROM Marca m WHERE m.descripcion = :descripcion")})
public class Marca implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    @Column(name = "id")
    private Long id;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @OneToMany(mappedBy = "marcaId")
    private List<Producto> productos;

    public Marca() {
    }

    public Marca(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the productos
     */
    public List<Producto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    
    
}
