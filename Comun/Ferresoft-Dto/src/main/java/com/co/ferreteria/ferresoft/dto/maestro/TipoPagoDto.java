package com.co.ferreteria.ferresoft.dto.maestro;

import java.io.Serializable;

/**
 *
 * @author johan
 */
public class TipoPagoDto implements Serializable{
    
    private Long id;
    
    private String descripcion;   
   
    private Integer importe;
    
    public TipoPagoDto(){
    }

    public TipoPagoDto(final Long id, final String descripcion, final Integer importe){
        this.id = id;
        this.descripcion = descripcion;
        this.importe = importe;
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

    public Integer getImporte() {
        return importe;
    }

    public void setImporte(Integer importe) {
        this.importe = importe;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TipoPagoDto) {
           return this.getId().equals(((TipoPagoDto) obj).getId()); 
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }
}
