package com.co.ferreteria.definitions.view.ventas;

import com.co.ferreteria.ferresoft.dto.maestro.ClienteDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johan
 */
@Local
public interface VentasViewLocal {    
    
  List<ClienteDto> buscarClientes(final ClienteDto cliente);
   
}
