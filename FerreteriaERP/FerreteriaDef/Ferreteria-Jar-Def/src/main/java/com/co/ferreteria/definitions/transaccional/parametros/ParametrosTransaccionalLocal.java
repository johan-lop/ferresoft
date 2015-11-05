package com.co.ferreteria.definitions.transaccional.parametros;

import com.co.ferreteria.ferresoft.dto.maestro.MarcaDto;
import com.co.ferreteria.ferresoft.dto.maestro.UnidadDto;
import java.sql.Connection;
import javax.ejb.Local;

/**
 *
 * @author johan
 */
@Local
public interface ParametrosTransaccionalLocal {    
    
    void guardarMarca(MarcaDto marca);
    
    void guardarUnidad(UnidadDto unidad);
    
    Connection obtenerConexion();
    
}
