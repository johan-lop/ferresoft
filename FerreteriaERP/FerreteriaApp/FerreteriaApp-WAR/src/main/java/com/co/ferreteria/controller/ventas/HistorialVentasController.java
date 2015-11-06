package com.co.ferreteria.controller.ventas;

import com.co.ferreteria.constantes.CommonConstants;
import com.co.ferreteria.controller.comun.ClienteController;
import com.co.ferreteria.facade.parametros.ParametrosFacade;
import com.co.ferreteria.facade.producto.ProductoFacade;
import com.co.ferreteria.facade.ventas.VentasFacade;
import com.co.ferreteria.ferresoft.dto.maestro.ClienteDto;
import com.co.ferreteria.ferresoft.dto.maestro.ProductoDto;
import com.co.ferreteria.ferresoft.dto.maestro.TipoPagoDto;
import com.co.ferreteria.ferresoft.dto.maestro.TipoVentaDto;
import com.co.ferreteria.ferresoft.dto.transaccional.DetalleVentaDto;
import com.co.ferreteria.ferresoft.dto.transaccional.VentaDto;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author johan
 */
@Named
@ViewScoped
@URLMapping(id = "ventas", pattern = "/ventas/venta", viewId = "/ventas/venta.page")
public class VentaController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ProductoFacade productoFacade;

    @Inject
    private ClienteController clienteController;

    @Inject
    private VentasFacade ventasFacade;

    @Inject
    private ParametrosFacade parametrosFacade;

    private String descripcion = "";

    private List<ProductoDto> productos;

    private List<DetalleVentaDto> detalleVenta;

    private List<TipoPagoDto> tiposPago;

    private List<TipoVentaDto> tiposVenta;

    private ClienteDto cliente;

    private VentaDto venta;

    private StreamedContent pdfFile;

    @PostConstruct
    public void init() {
        try {
            this.limpiarVenta();
            this.tiposVenta = parametrosFacade.obtenerTiposVenta();
            this.tiposPago = parametrosFacade.obtenerTiposPago();
            this.venta.setFechaFactura(new Date());
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al consultar los productos", ""));
        }

    }

    public void limpiarVenta() {
        this.detalleVenta = new ArrayList<>();
        this.venta = new VentaDto();
        this.cliente = new ClienteDto();
        this.consultar();
    }

    public void consultar() {
        ProductoDto producto = new ProductoDto();
        producto.setDescripcion(this.getDescripcion());
        this.productos = this.productoFacade.obtenerProducto(producto);
    }

    public void agregarProducto(ProductoDto producto) {
        boolean existe = false;
        for (DetalleVentaDto detalle : detalleVenta) {
            if (detalle.getProducto().getId().equals(producto.getId())) {
                existe = true;
            }
        }
        if (existe) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "El producto ya fue agregado a la factura", ""));
        } else {
            DetalleVentaDto detalle = new DetalleVentaDto();
            detalle.setProducto(producto);
            detalle.setPrecio(producto.getPrecio());
            detalle.setCantidad(1);
            detalle.setTotal(new Double(producto.getPrecio()));
            if (this.venta.getAplicaIva() != null && this.venta.getAplicaIva()) {
                detalle.setAplicaIva(Boolean.TRUE);
            }
            this.detalleVenta.add(detalle);
            calculaTotal();
        }
    }

    public void calculaValorPorCantidad(DetalleVentaDto detalle) {
        if (detalle.getCantidad() >= 0) {
            detalle.setTotal(new Double(detalle.getCantidad() * detalle.getPrecio()));
            calculaTotal();
        }
    }

    public void calculaTotal() {
        this.venta.setTotal(0.0);
        this.venta.setSubTotal(0.0);
        this.venta.setTotalIva(0.0);
        this.venta.setTotalImporte(0.0);
        for (DetalleVentaDto detalle : detalleVenta) {
            Double importe = (this.venta.getTipoPagoDto().getImporte() * detalle.getTotal()) / 100;
            this.venta.setSubTotal(this.venta.getSubTotal() + detalle.getTotal());
            this.venta.setTotal(this.venta.getTotal() + detalle.getTotal() + importe);
            this.venta.setTotalImporte(this.venta.getTotalImporte() + importe);
            if (detalle.getAplicaIva() != null && detalle.getAplicaIva()) {
                Double iva = detalle.getTotal() * CommonConstants.IVA;
                if (detalle.getIvaIncluido() != null && detalle.getIvaIncluido()) {
                    this.venta.setSubTotal(this.venta.getSubTotal() - iva);
                } else {
                    this.venta.setTotal(this.venta.getTotal() + iva);
                }
                this.venta.setTotalIva(this.venta.getTotalIva() + iva);
            } else {
                detalle.setIvaIncluido(Boolean.FALSE);
            }
        }
    }

    public void eliminarDetalle(DetalleVentaDto detalle) {
        this.detalleVenta.remove(detalle);
        this.calculaTotal();
    }

    public void aplicaIvaFactura() {
        for (DetalleVentaDto detalle : detalleVenta) {
            if (this.venta.getTipoVentaDto().getId() != 3) {
                detalle.setAplicaIva(Boolean.FALSE);
                detalle.setIvaIncluido(Boolean.FALSE);
                this.venta.setAplicaIva(Boolean.FALSE);
            } else if (this.venta.getAplicaIva()) {
                detalle.setAplicaIva(Boolean.TRUE);
            } else {
                detalle.setAplicaIva(Boolean.FALSE);
            }
        }
        calculaTotal();
    }

    public void seleccionarCliente() {
        if (clienteController.getCliente() != null) {
            this.cliente = this.clienteController.getCliente();
        }
    }

    public void guardarVenta() {
        try {
            if (this.detalleVenta.size() > 0) {
                this.venta.setDetalleVenta(this.detalleVenta);
                this.venta.setClienteDto(this.cliente);
                this.venta = this.ventasFacade.guardarVenta(venta);
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Venta Almacenada Correctamente", ""));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Debe agregar almenos un producto a la venta", ""));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar venta"
                            + e.getMessage(), ""));
        }
    }

    public void imprimePdf() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletResponse response = (HttpServletResponse) ec.getResponse();
        final Map parametros = new HashMap();

        try {
            parametros.put("VENTA_ID", this.venta.getId());
            parametros.put("ES_COPIA", false);
            JasperPrint printer = new JasperPrint();
            InputStream inputStream = null;
            try {
                ServletContext servletContext = (ServletContext) ec.getContext();
                if (this.venta.getTipoVentaDto().getId() == 3) {
                    inputStream = new FileInputStream(servletContext.getRealPath("/reportes/facturaVenta.jasper"));
                } else if (this.venta.getTipoVentaDto().getId() == 2) {
                    inputStream = new FileInputStream(servletContext.getRealPath("/reportes/remision.jasper"));
                }
                printer = JasperFillManager.fillReport(inputStream, parametros, this.parametrosFacade.obtenerConexion());
            } catch (Exception e) {
                System.err.println("Error " + e.getMessage());
            }
            response.addHeader("Content-disposition", "attachment; filename=report.pdf");

            final ServletOutputStream servletOutputStream = response.getOutputStream();
            JasperExportManager.exportReportToPdfStream(printer, servletOutputStream);
            FacesContext.getCurrentInstance().responseComplete();
        } catch (final Exception e) {
            System.err.println("Error" + e.getMessage());

        }
    }

    /**
     * @return the productos
     */
    public List<ProductoDto> getProductos() {
        return productos;
    }

    /**
     * @param productos the productos to set
     */
    public void setProductos(List<ProductoDto> productos) {
        this.productos = productos;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<DetalleVentaDto> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(List<DetalleVentaDto> detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public VentaDto getVenta() {
        return venta;
    }

    public void setVenta(VentaDto venta) {
        this.venta = venta;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public List<TipoPagoDto> getTiposPago() {
        return tiposPago;
    }

    public void setTiposPago(List<TipoPagoDto> tiposPago) {
        this.tiposPago = tiposPago;
    }

    public List<TipoVentaDto> getTiposVenta() {
        return tiposVenta;
    }

    public void setTiposVenta(List<TipoVentaDto> tiposVenta) {
        this.tiposVenta = tiposVenta;
    }

}
