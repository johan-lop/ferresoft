package com.co.ferreteria.ferresoft.dto.maestro;

import java.io.Serializable;

/**
 *
 * @author johan
 */
public class MunicipioDto implements Serializable {

    private Integer id;

    private String codigo;

    private String descripcion;

    public MunicipioDto(final Integer id, final String codigo, final String descripcion) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public MunicipioDto() {
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MunicipioDto) {
            return this.getId().equals(((MunicipioDto) obj).getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }
}
