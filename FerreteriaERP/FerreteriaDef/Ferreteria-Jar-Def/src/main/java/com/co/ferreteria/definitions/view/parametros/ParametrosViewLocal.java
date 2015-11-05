package com.co.ferreteria.definitions.view.parametros;

import com.co.ferreteria.ferresoft.dto.maestro.DepartamentoDto;
import com.co.ferreteria.ferresoft.dto.maestro.MarcaDto;
import com.co.ferreteria.ferresoft.dto.maestro.MunicipioDto;
import com.co.ferreteria.ferresoft.dto.maestro.TipoIdentificacionDto;
import com.co.ferreteria.ferresoft.dto.maestro.TipoPagoDto;
import com.co.ferreteria.ferresoft.dto.maestro.TipoVentaDto;
import com.co.ferreteria.ferresoft.dto.maestro.UnidadDto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author johan
 */
@Local
public interface ParametrosViewLocal {    
    
    List<MarcaDto> obtenerMarcas();
    
    List<UnidadDto> obtenerUnidades();
    
    List<DepartamentoDto> obtenerDepartamentos();
    
    List<MunicipioDto> obtenerMunicipios(DepartamentoDto departamento);
    
    List<TipoIdentificacionDto> obtenerTiposIdentificacion();
    
    List<TipoPagoDto> obtenerTiposPago();
    
    List<TipoVentaDto> obtenerTiposVenta();
}
