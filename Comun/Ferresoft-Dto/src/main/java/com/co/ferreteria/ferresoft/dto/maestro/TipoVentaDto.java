package com.co.ferreteria.ferresoft.dto.maestro;

import java.io.Serializable;

/**
 *
 * @author johan
 */
public class TipoVentaDto implements Serializable{
    
    private Long id;
    
    private String descripcion;   
   
    
    public TipoVentaDto(){
    }

    public TipoVentaDto(final Long id, final String descripcion){
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TipoVentaDto) {
           return this.getId().equals(((TipoVentaDto) obj).getId()); 
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }
    
}
