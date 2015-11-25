package com.co.ferreteria.definitions.transaccional.producto;

import com.co.ferreteria.ferresoft.dto.maestro.ProductoDto;
import javax.ejb.Local;

/**
 *
 * @author johan
 */
@Local
public interface ProductoTransaccionalLocal {    
    
   void guardarProducto(ProductoDto producto);
   
   void actualizarProducto(ProductoDto productoDto);
    
}
