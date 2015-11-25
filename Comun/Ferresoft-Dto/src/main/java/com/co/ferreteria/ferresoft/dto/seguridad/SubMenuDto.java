package com.co.ferreteria.ferresoft.dto.seguridad;

import java.io.Serializable;
import java.util.List;

/**
 * Dto para la calse marca.
 * 
 * @author johan
 */
public class SubMenuDto implements Serializable{
    
    private Long id;
    
    private String titulo;
    
    private List<MenuItemDto> items;
    
    private Boolean activo;
    
    public SubMenuDto() {}
    
    public SubMenuDto(final Long id, final String titulo) {
        this.id = id;
        this.titulo = titulo;
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

    public List<MenuItemDto> getItems() {
        return items;
    }

    public void setItems(List<MenuItemDto> items) {
        this.items = items;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    
}
