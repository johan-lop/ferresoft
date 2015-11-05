/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ferreteria.facade.ventas;

import com.co.ferreteria.definitions.transaccional.ventas.VentasTransaccionalLocal;
import com.co.ferreteria.definitions.view.ventas.VentasViewLocal;
import com.co.ferreteria.ferresoft.dto.maestro.ClienteDto;
import com.co.ferreteria.ferresoft.dto.transaccional.VentaDto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

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

    public void guardaCliente(final ClienteDto cliente) {
        this.ventasService.guardarCliente(cliente);
    }

    public List<ClienteDto> buscarClientes(final ClienteDto cliente) {
        return this.ventasViewService.buscarClientes(cliente);
    }
    
    public VentaDto guardarVenta(final VentaDto venta) {
        return this.ventasService.guardarVenta(venta);
    }
}
