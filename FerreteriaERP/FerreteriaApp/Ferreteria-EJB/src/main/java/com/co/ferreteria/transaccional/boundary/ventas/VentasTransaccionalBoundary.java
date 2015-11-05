package com.co.ferreteria.transaccional.boundary.ventas;

import com.co.ferreteria.definitions.transaccional.ventas.VentasTransaccionalLocal;
import com.co.ferreteria.ferresoft.dto.maestro.ClienteDto;
import com.co.ferreteria.ferresoft.dto.transaccional.DetalleVentaDto;
import com.co.ferreteria.ferresoft.dto.transaccional.VentaDto;
import com.co.ferreteria.ferresoft.model.maestros.Cliente;
import com.co.ferreteria.ferresoft.model.maestros.Municipio;
import com.co.ferreteria.ferresoft.model.maestros.Producto;
import com.co.ferreteria.ferresoft.model.maestros.TipoIdentificacion;
import com.co.ferreteria.ferresoft.model.maestros.TipoPago;
import com.co.ferreteria.ferresoft.model.maestros.TipoVenta;
import com.co.ferreteria.ferresoft.model.transaccional.DetalleVenta;
import com.co.ferreteria.ferresoft.model.transaccional.Venta;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author johan
 */
@Stateless
public class VentasTransaccionalBoundary implements VentasTransaccionalLocal {

    @PersistenceContext
    EntityManager em;

    @Override
    public void guardarCliente(final ClienteDto clienteDto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteDto.getNombre());
        cliente.setCelular(clienteDto.getCelular());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setNumeroDocumento(clienteDto.getNumeroIdentificacion());
        cliente.setContacto(clienteDto.getContacto());
        cliente.setDireccion(clienteDto.getDireccion());
        TipoIdentificacion tipoIdentificacion = new TipoIdentificacion();
        tipoIdentificacion.setId(clienteDto.getTipoIdentificacion().getId());
        cliente.setTipoDocumento(tipoIdentificacion);
        Municipio municipio = new Municipio();
        municipio.setId(clienteDto.getMunicipio().getId());
        cliente.setMunicipio(municipio);
        if (clienteDto.getId() != null) {
            cliente.setId(clienteDto.getId());
            em.merge(cliente);
        } else {
            em.persist(cliente);
        }
    }

    @Override
    public VentaDto guardarVenta(final VentaDto ventaDto) {
        Venta venta = new Venta();
        venta.setNumeroFactura(ventaDto.getNumeroFactura());
        venta.setNumeroRemision(ventaDto.getNumeroRemision());
        venta.setAplicaIva(ventaDto.getAplicaIva());
        venta.setSubtotal(ventaDto.getSubTotal());
        venta.setTotalIva(ventaDto.getTotalIva());
        venta.setTotal(ventaDto.getTotal());
        venta.setFechaFactura(ventaDto.getFechaFactura());
        venta.setFechaVencimiento(ventaDto.getFechaVencimiento());
        venta.setTotalImporte(ventaDto.getTotalImporte());
        if (ventaDto.getClienteDto().getId() != null) {
            Cliente cliente = new Cliente();
            cliente.setId(ventaDto.getClienteDto().getId());
            venta.setClienteId(cliente);
        }
        if (ventaDto.getTipoPagoDto() != null) {
            TipoPago tipoPago = new TipoPago();
            tipoPago.setId(ventaDto.getTipoPagoDto().getId());
            venta.setTipoPago(tipoPago);
        }
        if (ventaDto.getTipoVentaDto() != null) {
            TipoVenta tipoVenta = new TipoVenta();
            tipoVenta.setId(ventaDto.getTipoVentaDto().getId());
            venta.setTipoVenta(tipoVenta);
        }        
        em.persist(venta);
        for (DetalleVentaDto det : ventaDto.getDetalleVenta()) {
            DetalleVenta detalleVenta = new DetalleVenta();
            detalleVenta.setVentaId(venta);
            Producto producto = new Producto();
            producto.setId(det.getProducto().getId());
            detalleVenta.setProducto(producto);
            detalleVenta.setCantidad(det.getCantidad());
            detalleVenta.setAplicaIva(det.getAplicaIva());
            detalleVenta.setIvaIncluido(det.getIvaIncluido());
            detalleVenta.setPrecio(det.getPrecio());
            detalleVenta.setTotal(det.getTotal());
            em.persist(detalleVenta);
            this.actualizarStokProducto(det.getProducto().getId(), det.getCantidad());
        }
        ventaDto.setId(venta.getId());
        return ventaDto;
    }

    private void actualizarStokProducto(final Integer idProducto, final Integer cantidad) {
        Producto producto = (Producto) em.createNamedQuery("Producto.findById")
                .setParameter("id", idProducto).getSingleResult();
        em.createNamedQuery("Producto.updateStockById")
                .setParameter("stock", producto.getStock() - cantidad)
                .setParameter("id", idProducto).executeUpdate();
    }

}
