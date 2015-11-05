/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ferreteria.ferresoft.model.seguridad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author johan
 */
@Entity
@Table(name = "menu", schema = "seguridad" )
@NamedQueries({
    @NamedQuery(name = "Menu.findSubMenuDtoByRol", 
            query = "select new com.co.ferreteria.ferresoft.dto.seguridad.SubMenuDto"
            + "(m.id, m.titulo) from Menu m where m.rol.id = :rolId and m.padreId is null"),
    @NamedQuery(name = "Menu.findMenuItemDtoBySubMenuAndRol", 
            query = "select new com.co.ferreteria.ferresoft.dto.seguridad.MenuItemDto"
                    + "(m.titulo, m.link, m.id) from Menu m where m.rol.id = :rolId and m.padreId.id = :padreId")})
public class Menu implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "icono")
    private String icono;
    
    @Column(name = "link")
    private String link;
    
    @Column(name = "titulo")
    private String titulo;
    
    @JoinColumn(name = "padre_id")
    @ManyToOne()
    private Menu padreId;
    
    @JoinColumn(name = "rol_id")
    @ManyToOne(optional = false)
    private Rol rol;

    public Menu() {
    }

    public Menu(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Menu getPadreId() {
        return padreId;
    }

    public void setPadreId(Menu padreId) {
        this.padreId = padreId;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.co.ferreteria.ferresoft.model.seguridad.Menu[ id=" + id + " ]";
    }
    
}
