/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ferreteria.facade.producto;

import com.co.ferreteria.definitions.transaccional.producto.ProductoTransaccionalLocal;
import com.co.ferreteria.definitions.view.producto.ProductoViewLocal;
import com.co.ferreteria.ferresoft.dto.maestro.ProductoDto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 * Fachada de producto.
 * 
 * @author johan
 */

public class ProductoFacade implements Serializable{

    @EJB
    private ProductoViewLocal productoService;
    
    @EJB
    private ProductoTransaccionalLocal productoTransaccionalLocal;
    
    public List<ProductoDto> obtenerProducto(final ProductoDto productoDto) {
        return productoService.obtenerProductos(productoDto);
    } 
    
    public void guardarProducto(ProductoDto productoDto) {
        this.productoTransaccionalLocal.guardarProducto(productoDto);
    }
    
    public void actualizarProducto(final ProductoDto producto) {
        this.productoTransaccionalLocal.actualizarProducto(producto);
    }
    
}
