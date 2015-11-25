package com.co.ferreteria.controller.producto;

import com.co.ferreteria.facade.parametros.ParametrosFacade;
import com.co.ferreteria.facade.producto.ProductoFacade;
import com.co.ferreteria.ferresoft.dto.maestro.MarcaDto;
import com.co.ferreteria.ferresoft.dto.maestro.ProductoDto;
import com.co.ferreteria.ferresoft.dto.maestro.UnidadDto;
import com.ocpsoft.pretty.faces.annotation.URLMapping;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;

/**
 *
 * @author johan
 */
@Named
@ViewScoped
@URLMapping(id = "productos", pattern = "/inventario/productos", viewId = "/inventario/productos.page")
public class EditarProductoController implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private ProductoFacade productoFacade;

    @Inject
    private ParametrosFacade parametrosFacade;

    private String descripcion = "";

    private ProductoDto productoNuevo;

    private MarcaDto marcaNueva = new MarcaDto();

    private UnidadDto unidadNueva = new UnidadDto();

    private List<ProductoDto> productos;

    private List<MarcaDto> marcas;

    private List<UnidadDto> unidades;

    @PostConstruct
    public void init() {
        try {
            this.setProductoNuevo(new ProductoDto());
            this.getProductoNuevo().setMarcaDto(new MarcaDto());
            this.getProductoNuevo().setUnidadDto(new UnidadDto());
            this.marcas = parametrosFacade.obtenerMarcas();
            this.unidades = parametrosFacade.obtenerUnidades();
            this.consultar();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al consultar los productos", ""));
        }

    }

    public void consultar() {
        ProductoDto producto = new ProductoDto();
        producto.setDescripcion(this.getDescripcion());
        this.productos = this.productoFacade.obtenerProducto(producto);
    }

    public void crearNuevaMarca() {
        try {
            this.parametrosFacade.guardarMarca(this.marcaNueva);
            this.marcas = parametrosFacade.obtenerMarcas();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Marca Almacenada Correctamente", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al almacenar la Marca", ""));
        }
    }

    public void crearNuevaUnidad() {
        try {
            this.parametrosFacade.guardarUnidad(this.unidadNueva);
            this.unidades = parametrosFacade.obtenerUnidades();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Unidad Almacenada Correctamente", ""));
            unidadNueva = new UnidadDto();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al almacenar la Unidad", ""));
        }
    }

    public void guardarProducto() {
        try {
            this.productoFacade.guardarProducto(this.productoNuevo);
            this.setProductoNuevo(new ProductoDto());
            this.getProductoNuevo().setMarcaDto(new MarcaDto());
            this.getProductoNuevo().setUnidadDto(new UnidadDto());
            this.consultar();
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto Almacenado Correctamente", ""));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al almacenar el producto", ""));
        }
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            DataTable s = (DataTable) event.getSource();
            ProductoDto pd = (ProductoDto) s.getRowData();
            try {
                this.productoFacade.actualizarProducto(pd);
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto Actualizado Correctamente", ""));
            } catch (Exception e) {
                 FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al actualizar el producto", null));
            }
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

    /**
     * @return the productoNuevo
     */
    public ProductoDto getProductoNuevo() {
        return productoNuevo;
    }

    /**
     * @param productoNuevo the productoNuevo to set
     */
    public void setProductoNuevo(ProductoDto productoNuevo) {
        this.productoNuevo = productoNuevo;
    }

    /**
     * @return the marcas
     */
    public List<MarcaDto> getMarcas() {
        return marcas;
    }

    /**
     * @param marcas the marcas to set
     */
    public void setMarcas(List<MarcaDto> marcas) {
        this.marcas = marcas;
    }

    /**
     * @return the unidades
     */
    public List<UnidadDto> getUnidades() {
        return unidades;
    }

    /**
     * @param unidades the unidades to set
     */
    public void setUnidades(List<UnidadDto> unidades) {
        this.unidades = unidades;
    }

    /**
     * @return the marcaNueva
     */
    public MarcaDto getMarcaNueva() {
        return marcaNueva;
    }

    /**
     * @param marcaNueva the marcaNueva to set
     */
    public void setMarcaNueva(MarcaDto marcaNueva) {
        this.marcaNueva = marcaNueva;
    }

    /**
     * @return the unidadNueva
     */
    public UnidadDto getUnidadNueva() {
        return unidadNueva;
    }

    /**
     * @param unidadNueva the unidadNueva to set
     */
    public void setUnidadNueva(UnidadDto unidadNueva) {
        this.unidadNueva = unidadNueva;
    }

}
