package com.co.ferreteria.facade.parametros;

import com.co.ferreteria.definitions.transaccional.parametros.ParametrosTransaccionalLocal;
import com.co.ferreteria.definitions.view.parametros.ParametrosViewLocal;
import com.co.ferreteria.definitions.view.seguridad.MenuViewLocal;
import com.co.ferreteria.ferresoft.dto.maestro.DepartamentoDto;
import com.co.ferreteria.ferresoft.dto.maestro.MarcaDto;
import com.co.ferreteria.ferresoft.dto.maestro.MunicipioDto;
import com.co.ferreteria.ferresoft.dto.maestro.TipoIdentificacionDto;
import com.co.ferreteria.ferresoft.dto.maestro.TipoPagoDto;
import com.co.ferreteria.ferresoft.dto.maestro.TipoVentaDto;
import com.co.ferreteria.ferresoft.dto.maestro.UnidadDto;
import com.co.ferreteria.ferresoft.dto.seguridad.MenuDto;
import java.io.Serializable;
import java.sql.Connection;
import java.util.List;
import javax.ejb.EJB;

/**
 * Fachada de producto.
 * 
 * @author johan
 */

public class ParametrosFacade implements Serializable{

    @EJB
    private ParametrosViewLocal parametrosViewLocal;
    
    @EJB
    private ParametrosTransaccionalLocal parametrosTransaccionalLocal;
    
    @EJB
    private MenuViewLocal menuViewLocal;
    
    
    public List<MarcaDto> obtenerMarcas() {
        return parametrosViewLocal.obtenerMarcas();
    } 
    
    public List<UnidadDto> obtenerUnidades() {
        return parametrosViewLocal.obtenerUnidades();
    } 
    
    public void guardarMarca(MarcaDto marca) {
        this.parametrosTransaccionalLocal.guardarMarca(marca);
    }
    
    public void guardarUnidad(UnidadDto unidad) {
        this.parametrosTransaccionalLocal.guardarUnidad(unidad);
    }
    
    public MenuDto generaMenuPorUsuario(final Long id) {
        return this.menuViewLocal.generarMenuPorUsuario(id);
    }
    
    public List<DepartamentoDto> obtenerDepartamentos() {
        return this.parametrosViewLocal.obtenerDepartamentos();
    }
    
    public List<MunicipioDto> obtenerMunicipios(DepartamentoDto departamento) {
        return this.parametrosViewLocal.obtenerMunicipios(departamento);
    }
    
    public List<TipoIdentificacionDto> obtenerTiposIdentificacion(){
        return this.parametrosViewLocal.obtenerTiposIdentificacion();
    }
    
    public List<TipoPagoDto> obtenerTiposPago() {
        return this.parametrosViewLocal.obtenerTiposPago();
    }
    
    public List<TipoVentaDto> obtenerTiposVenta() {
        return this.parametrosViewLocal.obtenerTiposVenta();
    }
    
    public Connection obtenerConexion() {
        return parametrosTransaccionalLocal.obtenerConexion();
    }
}
