package com.co.ferreteria.definitions.view.ventas;

import com.co.ferreteria.ferresoft.dto.maestro.ClienteDto;
import com.co.ferreteria.ferresoft.dto.transaccional.VentaDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johan
 */
@Local
public interface VentasViewLocal {    
    
  List<ClienteDto> buscarClientes(final ClienteDto cliente);
  
  List<VentaDto> listarVentas();
   
}
