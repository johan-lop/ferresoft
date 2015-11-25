package com.co.ferreteria.view.boundary.parametros;

import com.co.ferreteria.definitions.view.parametros.ParametrosViewLocal;
import com.co.ferreteria.ferresoft.dto.maestro.DepartamentoDto;
import com.co.ferreteria.ferresoft.dto.maestro.MarcaDto;
import com.co.ferreteria.ferresoft.dto.maestro.MunicipioDto;
import com.co.ferreteria.ferresoft.dto.maestro.TipoIdentificacionDto;
import com.co.ferreteria.ferresoft.dto.maestro.TipoPagoDto;
import com.co.ferreteria.ferresoft.dto.maestro.TipoVentaDto;
import com.co.ferreteria.ferresoft.dto.maestro.UnidadDto;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author johan
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ParametrosViewBoundary implements ParametrosViewLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<MarcaDto> obtenerMarcas() {
        return em.createNamedQuery("Marca.findAll", MarcaDto.class).getResultList();
    }

    @Override
    public List<UnidadDto> obtenerUnidades() {
        return em.createNamedQuery("Unidad.findAll", UnidadDto.class).getResultList();
    }

    @Override
    public List<DepartamentoDto> obtenerDepartamentos() {
        return em.createNamedQuery("Departamento.findAll", DepartamentoDto.class).getResultList();
    }

    @Override
    public List<MunicipioDto> obtenerMunicipios(final DepartamentoDto departamento) {
        return em.createNamedQuery("Municipio.findAllByDepartamento", MunicipioDto.class)
                .setParameter("departamentoId", departamento.getId())
                .getResultList();
    }

    @Override
    public List<TipoIdentificacionDto> obtenerTiposIdentificacion() {
        return em.createNamedQuery("TipoIdentificacion.findAll", TipoIdentificacionDto.class)
                .getResultList();
    }

    @Override
    public List<TipoPagoDto> obtenerTiposPago() {
        return em.createNamedQuery("TipoPago.findAll", TipoPagoDto.class)
                .getResultList();
    }

    @Override
    public List<TipoVentaDto> obtenerTiposVenta() {
        return em.createNamedQuery("TipoVenta.findAll", TipoVentaDto.class)
                .getResultList();
    }

}
