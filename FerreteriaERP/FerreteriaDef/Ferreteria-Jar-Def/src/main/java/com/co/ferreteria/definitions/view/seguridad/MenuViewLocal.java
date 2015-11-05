package com.co.ferreteria.definitions.view.seguridad;

import com.co.ferreteria.ferresoft.dto.seguridad.MenuDto;
import javax.ejb.Local;

/**
 *
 * @author johan
 */
@Local
public interface MenuViewLocal {  
    
    MenuDto generarMenuPorUsuario(Long usuarioId);
    
}
