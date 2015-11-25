package com.co.ferreteria.controller.compras;

import com.co.ferreteria.controller.ventas.*;
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
@URLMapping(id = "compras", pattern = "/compras/compra", viewId = "/compras/compra.page")
public class CompraController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ProductoFacade productoFacade;

    @Inject
    private ClienteController clienteController;

    @Inject
    private VentasFacade ventasFacade;

    @Inject
    private ParametrosFacade parametrosFacade;

    

    @PostConstruct
    public void init() {
        try {
            
        } catch (Exception e) {
            
        }

    }

    
}
