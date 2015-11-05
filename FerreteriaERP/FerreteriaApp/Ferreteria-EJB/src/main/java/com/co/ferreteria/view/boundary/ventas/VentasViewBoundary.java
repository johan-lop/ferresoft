package com.co.ferreteria.view.boundary.ventas;

import com.co.ferreteria.definitions.view.ventas.VentasViewLocal;
import com.co.ferreteria.ferresoft.dto.maestro.ClienteDto;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author johan
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class VentasViewBoundary implements VentasViewLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<ClienteDto> buscarClientes(final ClienteDto cliente) {
        StringBuilder sb = new StringBuilder();
        sb.append("select new com.co.ferreteria.ferresoft.dto.maestro.ClienteDto(c.id, "
                + "c.nombre, mun.departamentoId.id, mun.departamentoId.descripcion, mun.id, "
                + "mun.descripcion, td.id, td.descripcion, c.numeroDocumento, c.direccion, c.telefono, c.celular, c.contacto) "
                + "from Cliente c join c.tipoDocumento td join c.municipio mun where UPPER(c.nombre) like "
                + " :nombre ");              
        if (cliente.getNumeroIdentificacion() != null && !"".equals(cliente.getNumeroIdentificacion())) {
            sb.append(" and c.numeroDocumento = :numeroDocumento ");
        }
        if (cliente.getTipoIdentificacion() != null) {
            sb.append(" and td.id = :tipoDocumento ");
        }
        Query query = em.createQuery(sb.toString(), ClienteDto.class).setParameter("nombre", "%" + 
                cliente.getNombre().toUpperCase() + "%");
        if (cliente.getNumeroIdentificacion() != null && !"".equals(cliente.getNumeroIdentificacion())) {
            query.setParameter("numeroDocumento", cliente.getNumeroIdentificacion());
        }
        if (cliente.getTipoIdentificacion() != null) {
            query.setParameter("tipoDocumento", cliente.getTipoIdentificacion().getId());
        }
       
        return query.getResultList();
    }

}
