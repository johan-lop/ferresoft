package com.co.ferreteria.transaccional.boundary.producto;

import com.co.ferreteria.definitions.transaccional.producto.ProductoTransaccionalLocal;
import com.co.ferreteria.ferresoft.dto.maestro.ProductoDto;
import com.co.ferreteria.ferresoft.model.maestros.Marca;
import com.co.ferreteria.ferresoft.model.maestros.Producto;
import com.co.ferreteria.ferresoft.model.maestros.Unidad;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author johan
 */
@Stateless
public class ProductoTransaccionalBoundary implements ProductoTransaccionalLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public void guardarProducto(ProductoDto producto) {
        Producto prod = new Producto();
        prod.setCosto(producto.getCosto());
        prod.setDescripcion(producto.getDescripcion());
        prod.setPrecio(producto.getPrecio());
        prod.setStock(producto.getStock());
        Marca marca = new Marca();
        Unidad unidad = new Unidad();
        marca.setId(producto.getMarcaDto().getId());
        unidad.setId(producto.getUnidadDto().getId());
        prod.setMarcaId(marca);
        prod.setUnidadId(unidad);
        em.persist(prod);
    }

    @Override
    public void actualizarProducto(ProductoDto productoDto) {
        StringBuilder sb = new StringBuilder("UPDATE Producto p set p.descripcion = :descripcion, "
                + "p.precio = :precio, p.costo = :costo, p.stock = :stock "
                + " ");
        if (productoDto.getUnidadDto().getId() != null) {
            sb.append(", p.unidadId.id = :unidadId ");
        }
        if (productoDto.getMarcaDto().getId() != null) {
            sb.append(", p.marcaId.id = :marcaId ");
        }
        sb.append("WHERE id = :id)");
        Query query = em.createQuery(sb.toString());
        query.setParameter("descripcion", productoDto.getDescripcion());
        query.setParameter("precio", productoDto.getPrecio());
        query.setParameter("costo", productoDto.getCosto());
        query.setParameter("stock", productoDto.getStock());
        if (productoDto.getUnidadDto().getId() != null) {
            query.setParameter("unidadId", productoDto.getUnidadDto().getId());
        }
        if (productoDto.getMarcaDto().getId() != null) {
            query.setParameter("marcaId", productoDto.getMarcaDto().getId());
        }
        query.setParameter("id", productoDto.getId())
                .executeUpdate();
    }

}
