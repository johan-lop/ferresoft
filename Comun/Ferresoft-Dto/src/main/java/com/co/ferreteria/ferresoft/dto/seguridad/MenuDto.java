package com.co.ferreteria.ferresoft.dto.seguridad;

import java.io.Serializable;
import java.util.List;

/**
 * Dto para la calse marca.
 *
 * @author johan
 */
public class MenuDto implements Serializable {

    private List<SubMenuDto> items;

    public MenuDto(List<SubMenuDto> items) {
        this.items = items;
    }

    public MenuDto(){}
    
    public List<SubMenuDto> getItems() {
        return items;
    }

    public void setItems(List<SubMenuDto> items) {
        this.items = items;
    }

}
