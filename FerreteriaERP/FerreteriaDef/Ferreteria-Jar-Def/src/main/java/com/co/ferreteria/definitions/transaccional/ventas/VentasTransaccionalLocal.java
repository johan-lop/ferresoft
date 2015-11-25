package com.co.ferreteria.definitions.transaccional.ventas;

import com.co.ferreteria.ferresoft.dto.maestro.ClienteDto;
import com.co.ferreteria.ferresoft.dto.transaccional.VentaDto;
import javax.ejb.Local;

/**
 *
 * @author johan
 */
@Local
public interface VentasTransaccionalLocal {    
    
   void guardarCliente(final ClienteDto cliente);
   
   VentaDto guardarVenta(final VentaDto venta);
   
}
