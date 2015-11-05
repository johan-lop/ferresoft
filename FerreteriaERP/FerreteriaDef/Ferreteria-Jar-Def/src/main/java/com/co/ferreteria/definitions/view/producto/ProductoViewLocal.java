package com.co.ferreteria.definitions.view.producto;

import com.co.ferreteria.ferresoft.dto.maestro.ProductoDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johan
 */
@Local
public interface ProductoViewLocal {    
    
    List<ProductoDto> obtenerProductos(final ProductoDto productoDto);
    
}
