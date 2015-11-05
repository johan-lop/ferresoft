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
import javax.validation.constraints.Size;

/**
 *
 * @author johan
 */
@Entity
@Table(name = "tipo_identificacion", schema = "maestro")
@NamedQueries({
    @NamedQuery(name = "TipoIdentificacion.findAll", query = "SELECT new com.co.ferreteria.ferresoft.dto.maestro.TipoIdentificacionDto"
            + "(t.id, t.descripcion, t.diminutivo) FROM TipoIdentificacion t"),
    })
public class TipoIdentificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Size(max = 10)
    @Column(name = "diminutivo")
    private String diminutivo;
    
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;

    public TipoIdentificacion() {
    }

    public TipoIdentificacion(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDiminutivo() {
        return diminutivo;
    }

    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
        if (!(object instanceof TipoIdentificacion)) {
            return false;
        }
        TipoIdentificacion other = (TipoIdentificacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ferreteria.ferresoft.model.maestros.TipoIdentificacion[ id=" + id + " ]";
    }
    
}
