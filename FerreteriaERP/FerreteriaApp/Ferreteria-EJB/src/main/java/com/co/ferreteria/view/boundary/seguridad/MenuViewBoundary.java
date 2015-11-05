/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.co.ferreteria.view.boundary.seguridad;

import com.co.ferreteria.definitions.view.seguridad.MenuViewLocal;
import com.co.ferreteria.ferresoft.dto.seguridad.MenuDto;
import com.co.ferreteria.ferresoft.dto.seguridad.MenuItemDto;
import com.co.ferreteria.ferresoft.dto.seguridad.SubMenuDto;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class MenuViewBoundary implements MenuViewLocal {

    @PersistenceContext
    private EntityManager em;

    @Override
    public MenuDto generarMenuPorUsuario(Long usuarioId) {
        Long rol = 1L;
        List<SubMenuDto> subMenus = null;
        subMenus = em.createNamedQuery("Menu.findSubMenuDtoByRol",
                SubMenuDto.class)
                .setParameter("rolId", rol)
                .getResultList();
        for (SubMenuDto subMenu : subMenus) {

            List<MenuItemDto> items = em.createNamedQuery("Menu.findMenuItemDtoBySubMenuAndRol", MenuItemDto.class)
                    .setParameter("rolId", rol)
                    .setParameter("padreId", subMenu.getId())
                    .getResultList();
            subMenu.setItems(items);
        }

        return new MenuDto(subMenus);
    }
}
