/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ferreteria.view.boundary.producto;

import com.co.ferreteria.definitions.view.producto.ProductoViewLocal;
import com.co.ferreteria.ferresoft.dto.maestro.ProductoDto;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author johan
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ProductoViewBoundary implements ProductoViewLocal{

    @PersistenceContext
    EntityManager em;
    
    @Override
    public List<ProductoDto> obtenerProductos(final ProductoDto productoDto) {
        String desc = "%" + productoDto.getDescripcion().toUpperCase() + "%";
        return em.createNamedQuery("Producto.findLikeDescripcion", ProductoDto.class)
                .setParameter("descripcion", desc)
                .getResultList();
    }
    
}
