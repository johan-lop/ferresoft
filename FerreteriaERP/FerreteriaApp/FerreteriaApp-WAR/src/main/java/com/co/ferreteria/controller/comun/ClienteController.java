package com.co.ferreteria.controller.comun;

import com.co.ferreteria.facade.parametros.ParametrosFacade;
import com.co.ferreteria.facade.ventas.VentasFacade;
import com.co.ferreteria.ferresoft.dto.maestro.ClienteDto;
import com.co.ferreteria.ferresoft.dto.maestro.DepartamentoDto;
import com.co.ferreteria.ferresoft.dto.maestro.MunicipioDto;
import com.co.ferreteria.ferresoft.dto.maestro.TipoIdentificacionDto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author johan
 */
@Named
@ViewScoped
public class ClienteController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ParametrosFacade parametrosFacade;

    @Inject
    private VentasFacade ventasFacade;

    private List<DepartamentoDto> departamentos;

    private List<MunicipioDto> municipios;

    private ClienteDto cliente;

    private ClienteDto clienteBuscar;

    private List<TipoIdentificacionDto> tiposIdentificacion;

    private List<ClienteDto> clientes;

    @PostConstruct
    public void init() {
        try {
            this.departamentos = this.parametrosFacade.obtenerDepartamentos();
            this.municipios = new ArrayList<>();
            this.cliente = new ClienteDto();
            this.clienteBuscar = new ClienteDto();
            this.tiposIdentificacion = parametrosFacade.obtenerTiposIdentificacion();
            this.buscarClientes();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al cargar los parametros", ""));
        }

    }

    public void buscaMunicipios() {
        if (this.cliente.getDepartamento() != null) {
            this.municipios = this.parametrosFacade.obtenerMunicipios(this.cliente.getDepartamento());
        }
    }

    public void guardarCliente() {
        try {
            this.ventasFacade.guardaCliente(this.cliente);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente Guadado Exitosamente", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al guardar el cliente", ""));
        }
    }

    public void buscarClientes() {
        try {
            this.clientes = this.ventasFacade.buscarClientes(this.clienteBuscar);
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al consultar cliente", ""));
        }
    }

    public void limpiarCliente() {
        this.cliente = new ClienteDto();
    }
    
    public void editarCliente(ClienteDto cli) {
        this.cliente = cli;
        this.buscaMunicipios();
        
    }

    public List<DepartamentoDto> getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(List<DepartamentoDto> departamentos) {
        this.departamentos = departamentos;
    }

    public List<MunicipioDto> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(List<MunicipioDto> municipios) {
        this.municipios = municipios;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public List<TipoIdentificacionDto> getTiposIdentificacion() {
        return tiposIdentificacion;
    }

    public void setTiposIdentificacion(List<TipoIdentificacionDto> tiposIdentificacion) {
        this.tiposIdentificacion = tiposIdentificacion;
    }

    public ClienteDto getClienteBuscar() {
        return clienteBuscar;
    }

    public void setClienteBuscar(ClienteDto clienteBuscar) {
        this.clienteBuscar = clienteBuscar;
    }

    public List<ClienteDto> getClientes() {
        return clientes;
    }

    public void setClientes(List<ClienteDto> clientes) {
        this.clientes = clientes;
    }

}
