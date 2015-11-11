/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ferreteria.facade.ventas;

import com.co.ferreteria.definitions.transaccional.ventas.VentasTransaccionalLocal;
import com.co.ferreteria.definitions.view.ventas.VentasViewLocal;
import com.co.ferreteria.facade.parametros.ParametrosFacade;
import com.co.ferreteria.ferresoft.dto.maestro.ClienteDto;
import com.co.ferreteria.ferresoft.dto.maestro.TipoVentaDto;
import com.co.ferreteria.ferresoft.dto.transaccional.VentaDto;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * Fachada de producto.
 *
 * @author johan
 */
public class VentasFacade implements Serializable {

    @EJB
    private VentasTransaccionalLocal ventasService;

    @EJB
    private VentasViewLocal ventasViewService;
    
    @Inject
    private ParametrosFacade parametrosFacade;

    public void guardaCliente(final ClienteDto cliente) {
        this.ventasService.guardarCliente(cliente);
    }

    public List<ClienteDto> buscarClientes(final ClienteDto cliente) {
        return this.ventasViewService.buscarClientes(cliente);
    }
    
    public VentaDto guardarVenta(final VentaDto venta) {
        return this.ventasService.guardarVenta(venta);
    }
    
    public List<VentaDto> listarVentas() {
        return this.ventasViewService.listarVentas();
    }
    
    public void imprimePdf(final Long ventaId, final TipoVentaDto tipoVentaDto, final boolean esCopia,
            final Integer numeroRemision, final Integer numeroFactura) {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletResponse response = (HttpServletResponse) ec.getResponse();
        final Map parametros = new HashMap();

        try {
            parametros.put("VENTA_ID", ventaId);
            parametros.put("ES_COPIA", esCopia);
            JasperPrint printer = new JasperPrint();
            InputStream inputStream = null;
            String nombre = "";
            try {
                ServletContext servletContext = (ServletContext) ec.getContext();
                if (tipoVentaDto.getId() == 3) {
                    inputStream = new FileInputStream(servletContext.getRealPath("/reportes/facturaVenta.jasper"));
                    nombre = "FacturaVentaNo_" + numeroFactura;
                } else if (tipoVentaDto.getId() == 2) {
                    inputStream = new FileInputStream(servletContext.getRealPath("/reportes/remision.jasper"));
                    nombre = "RemisionNo_" + numeroRemision;
                }
                printer = JasperFillManager.fillReport(inputStream, parametros, this.parametrosFacade.obtenerConexion());
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al cargar el reporte"
                                + e.getMessage(), ""));
            }
            response.addHeader("Content-disposition", "attachment; filename=" + nombre + ".pdf");

            final ServletOutputStream servletOutputStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(printer, servletOutputStream);
            FacesContext.getCurrentInstance().responseComplete();
        } catch (final Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al generando el reporte"
                            + e.getMessage(), ""));
        }
    }
}
