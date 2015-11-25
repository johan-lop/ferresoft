package com.co.ferreteria.ferresoft.dto.seguridad;

import com.co.ferreteria.ferresoft.dto.maestro.*;
import java.io.Serializable;

/**
 * Dto para la calse marca.
 * 
 * @author johan
 */
public class MenuItemDto implements Serializable{
    
    private Long id;
    
    private String titulo;
    
    private String link;
    
    private Boolean activo;
    
    public MenuItemDto() {}
    
    public MenuItemDto(final String titulo, final String link, final Long id) {
        this.id = id;
        this.titulo = titulo;
        this.link = link;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    
}
