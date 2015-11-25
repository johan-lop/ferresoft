package com.co.ferreteria.ferresoft.dto.maestro;

import java.io.Serializable;

/**
 *
 * @author johan
 */
public class TipoIdentificacionDto implements Serializable{
    
    private Long id;
    
    private String descripcion;
    
    private String diminutivo;
    
    public TipoIdentificacionDto(){
    }

    public TipoIdentificacionDto(final Long id, final String descripcion, final String diminutivo){
        this.id = id;
        this.descripcion = descripcion;
        this.diminutivo = diminutivo;
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

    /**
     * @return the diminutivo
     */
    public String getDiminutivo() {
        return diminutivo;
    }

    /**
     * @param diminutivo the diminutivo to set
     */
    public void setDiminutivo(String diminutivo) {
        this.diminutivo = diminutivo;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TipoIdentificacionDto) {
           return this.getId().equals(((TipoIdentificacionDto) obj).getId()); 
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }
    
}
