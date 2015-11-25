package com.co.ferreteria.ferresoft.dto.maestro;

import java.io.Serializable;

/**
 *
 * @author johan
 */
public class ProductoDto implements Serializable{

    private Integer id;

    private String descripcion;

    private Integer precio;

    private Integer costo;

    private Integer stock;

    private MarcaDto marcaDto;

    private UnidadDto unidadDto;
    
     public ProductoDto(){}
    
    public ProductoDto(final Integer id, final String descripcion,
            final Integer precio, final Integer costo,
            final Integer stock, final String marca,
            final String unidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
        this.costo = costo;
        this.stock = stock;
        MarcaDto mar = new MarcaDto();
        mar.setDescripcion(marca);
        this.marcaDto = mar;
        UnidadDto uni = new UnidadDto();
        uni.setDescripcion(unidad);
        this.unidadDto = uni;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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

    /**
     * @return the precio
     */
    public Integer getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    /**
     * @return the costo
     */
    public Integer getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    /**
     * @return the stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * @return the marcaDto
     */
    public MarcaDto getMarcaDto() {
        return marcaDto;
    }

    /**
     * @param marcaDto the marcaDto to set
     */
    public void setMarcaDto(MarcaDto marcaDto) {
        this.marcaDto = marcaDto;
    }

    /**
     * @return the unidadDto
     */
    public UnidadDto getUnidadDto() {
        return unidadDto;
    }

    /**
     * @param unidadDto the unidadDto to set
     */
    public void setUnidadDto(UnidadDto unidadDto) {
        this.unidadDto = unidadDto;
    }
    
}
