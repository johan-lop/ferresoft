package com.co.ferreteria.ferresoft.model.maestros;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author johan
 */
@Entity
@Table(name = "municipio", schema = "maestro")
@NamedQueries({
    @NamedQuery(name = "Municipio.findAllByDepartamento", query = "SELECT new com.co.ferreteria.ferresoft.dto.maestro.MunicipioDto"
            + "(m.id, m.codigo, m.descripcion) FROM Municipio m where m.departamentoId.id =:departamentoId ")
})
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @Column(name = "id")
    private Integer id;

    @Size(max = 5)
    @Column(name = "codigo")
    private String codigo;

    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;

    @JoinColumn(name = "departamento_id", referencedColumnName = "id")
    @ManyToOne
    private Departamento departamentoId;

    public Municipio() {
    }

    public Municipio(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Departamento getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(Departamento departamentoId) {
        this.departamentoId = departamentoId;
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
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ferreteria.ferresoft.model.maestros.Municipio[ id=" + id + " ]";
    }

}
