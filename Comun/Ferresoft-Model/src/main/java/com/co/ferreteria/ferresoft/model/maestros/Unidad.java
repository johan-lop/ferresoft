package com.co.ferreteria.ferresoft.model.maestros;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author johan
 */
@Entity
@Table(schema = "maestro", name = "unidad")
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT NEW com.co.ferreteria.ferresoft.dto.maestro.UnidadDto"
            + "(u.id, u.descripcion, u.diminutivo) FROM Unidad u"),
    @NamedQuery(name = "Unidad.findById", query = "SELECT u FROM Unidad u WHERE u.id = :id"),
    @NamedQuery(name = "Unidad.findByDescripcion", query = "SELECT u FROM Unidad u WHERE u.descripcion = :descripcion"),
    @NamedQuery(name = "Unidad.findByDiminutivo", query = "SELECT u FROM Unidad u WHERE u.diminutivo = :diminutivo")})
public class Unidad implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    @Column(name = "id")
    private Long id;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "diminutivo")
    private String diminutivo;
    
    public Unidad() {
    }

    public Unidad(Long id) {
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

    public String getDiminutivo() {
        return diminutivo;
    }

    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
    }
    
}
