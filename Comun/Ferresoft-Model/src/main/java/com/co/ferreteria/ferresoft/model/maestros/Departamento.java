package com.co.ferreteria.ferresoft.model.maestros;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author johan
 */
@Entity
@Table(name = "departamento", schema = "maestro")
@NamedQueries({
    @NamedQuery(name = "Departamento.findAll", query = "SELECT new com.co.ferreteria.ferresoft.dto.maestro.DepartamentoDto "
            + "(d.id, d.codigo, d.descripcion) FROM Departamento d")
})
public class Departamento implements Serializable {

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

    @OneToMany(mappedBy = "departamentoId")
    private List<Municipio> municipioList;

    public Departamento() {
    }

    public Departamento(Integer id) {
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

    public List<Municipio> getMunicipioList() {
        return municipioList;
    }

    public void setMunicipioList(List<Municipio> municipioList) {
        this.municipioList = municipioList;
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
        if (!(object instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ferreteria.ferresoft.model.maestros.Departamento[ id=" + id + " ]";
    }

}
