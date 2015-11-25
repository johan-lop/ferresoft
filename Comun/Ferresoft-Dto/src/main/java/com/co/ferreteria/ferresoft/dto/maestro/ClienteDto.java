package com.co.ferreteria.ferresoft.dto.maestro;

import java.io.Serializable;

/**
 * Dto para la calse marca.
 * 
 * @author johan
 */
public class ClienteDto implements Serializable{
    
    private Long id;
    
    private String nombre;
    
    private DepartamentoDto departamento;
    
    private MunicipioDto municipio;
    
    private TipoIdentificacionDto tipoIdentificacion;
    
    private String numeroIdentificacion;
    
    private String direccion;
    
    private String telefono;
    
    private String celular;
    
    private String contacto;
    
    public ClienteDto() {
        this.nombre = "";
    }
    
   
    public ClienteDto(final Long id, final String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public ClienteDto(final Long id, final String nombre, final Integer departamentoId, 
            final String departamento, final Integer municipioId, final String municipio, 
            final Long tipoDocumentoId, final String tipoDocumento, final String numeroIdentificacion,
            final String direccion, final String telefono, final String celular, final String contacto) {
        this.id = id;
        this.nombre = nombre;
        if (departamentoId != null) {
            DepartamentoDto dpto = new DepartamentoDto(departamentoId,"", departamento);
            this.departamento = dpto;
        }
        if (municipioId != null) {
            MunicipioDto municipioDto = new MunicipioDto(municipioId, "", municipio);
            this.municipio = municipioDto;
        }
        if (tipoDocumentoId != null) {
            TipoIdentificacionDto tipoIden = new TipoIdentificacionDto(tipoDocumentoId, tipoDocumento, "");
            this.tipoIdentificacion = tipoIden;
        }
        this.numeroIdentificacion = numeroIdentificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.contacto = contacto;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DepartamentoDto getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentoDto departamento) {
        this.departamento = departamento;
    }

    public MunicipioDto getMunicipio() {
        return municipio;
    }

    public void setMunicipio(MunicipioDto municipio) {
        this.municipio = municipio;
    }

    public TipoIdentificacionDto getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(TipoIdentificacionDto tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    
}
