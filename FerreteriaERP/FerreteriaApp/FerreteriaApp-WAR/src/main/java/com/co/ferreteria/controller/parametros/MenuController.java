package com.co.ferreteria.controller.parametros;

import com.co.ferreteria.facade.parametros.ParametrosFacade;
import com.co.ferreteria.ferresoft.dto.seguridad.MenuDto;
import com.co.ferreteria.ferresoft.dto.seguridad.MenuItemDto;
import java.io.IOException;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

/**
 * Clase controladora del menú del sistema
 *
 * @author johan
 */
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Named
@SessionScoped
public class MenuController implements Serializable {

    private static final long serialVersionUID = 2778631210284879776L;

    private MenuDto menu = new MenuDto();
    
    @Inject
    private ParametrosFacade parametrosFacade;
    
    @PostConstruct
    public void iniciar() {
        this.menu = parametrosFacade.generaMenuPorUsuario(1L);
    }
    
    public void navigate(MenuItemDto menuItem) throws Exception {
        try {
            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getR‌​esponse();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            response.sendRedirect(request.getContextPath()
                    + menuItem.getLink());
        } catch (IOException e) {
            throw new Exception(
                    "Error ejecutando la navegación solicitada.");
        }
    }

    public MenuDto getMenu() {
        return menu;
    }

    public void setMenu(MenuDto menu) {
        this.menu = menu;
    }
    
    
}
