package com.co.ferreteria.controller.ventas;

import com.co.ferreteria.facade.parametros.ParametrosFacade;
import com.co.ferreteria.facade.ventas.VentasFacade;
import com.co.ferreteria.ferresoft.dto.maestro.TipoVentaDto;
import com.co.ferreteria.ferresoft.dto.transaccional.VentaDto;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named
@ViewScoped
@URLMapping(id = "historialVentas", pattern = "/ventas/historialVentas", viewId = "/ventas/historialVentas.page")
public class HistorialVentasController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private VentasFacade ventasFacade;

    @Inject
    private ParametrosFacade parametrosFacade;

    private List<VentaDto> ventas;

    private VentaDto filtroVenta;

    private List<TipoVentaDto> tiposVenta;

    @PostConstruct
    public void init() {
        this.filtroVenta = new VentaDto();
        this.buscar();
        this.tiposVenta = parametrosFacade.obtenerTiposVenta();
    }

    public void imprimePdf(final boolean esCopia, final VentaDto venta) {
        ventasFacade.imprimePdf(venta.getId(), venta.getTipoVentaDto(), esCopia,
                venta.getNumeroRemision(), venta.getNumeroFactura());
    }

    public void buscar() {
        this.ventas = ventasFacade.listarVentas(this.filtroVenta);
    }

    public List<VentaDto> getVentas() {
        return ventas;
    }

    public void setVentas(List<VentaDto> ventas) {
        this.ventas = ventas;
    }

    public VentaDto getFiltroVenta() {
        return filtroVenta;
    }

    public void setFiltroVenta(VentaDto filtroVenta) {
        this.filtroVenta = filtroVenta;
    }

    public List<TipoVentaDto> getTiposVenta() {
        return tiposVenta;
    }

    public void setTiposVenta(List<TipoVentaDto> tiposVenta) {
        this.tiposVenta = tiposVenta;
    }

}
