package com.co.ferreteria.ferresoft.dto.maestro;

import java.io.Serializable;

/**
 * Dto para la calse marca.
 * 
 * @author johan
 */
public class MarcaDto implements Serializable{
    
    private Long id;
    
    private String descripcion;
    
    public MarcaDto() {}
    
    public MarcaDto(final String desc) {
        this.descripcion = desc;
    }
    
    public MarcaDto(final Long id, final String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
