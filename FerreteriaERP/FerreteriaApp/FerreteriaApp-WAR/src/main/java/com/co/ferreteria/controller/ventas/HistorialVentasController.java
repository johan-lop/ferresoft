package com.co.ferreteria.controller.ventas;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
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

    @PostConstruct
    public void init() {
        
    }

   
}
