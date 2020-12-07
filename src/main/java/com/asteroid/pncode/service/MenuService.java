package com.asteroid.pncode.service;

import com.asteroid.pncode.dao.MenuDao;
import com.asteroid.pncode.pojo.Menu;
import com.asteroid.pncode.pojo.RoleMenu;
import com.asteroid.pncode.pojo.User;
import com.asteroid.pncode.pojo.UserRole;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author YuSai
 */
@Service
public class MenuService {

    @Autowired
    UserService userService;

    @Autowired
    UserRoleService userRoleService;

    @Autowired
    RoleMenuService roleMenuService;

    @Autowired
    MenuDao menuDao;

    public List<Menu> getMenusByCurrentUser() {
        // Get current user in DB.
//        String username = SecurityUtils.getSubject().getPrincipal().toString();
        User user = userService.getByUserName("admin");

        // Get roles' ids of current user.
        List<Integer> rids = userRoleService.listAllByUid(user.getId())
                .stream().map(UserRole::getRid).collect(Collectors.toList());

        // Get menu items of these roles.
        List<Integer> menuIds = roleMenuService.findAllByRid(rids)
                .stream().map(RoleMenu::getMid).collect(Collectors.toList());
        List<Menu> menus = menuDao.findAllById(menuIds).stream().distinct().collect(Collectors.toList());

        // Adjust the structure of the menu.
        handleMenus(menus);
        return menus;
    }

    public List<Menu> getMenusByRoleId(int rid) {
        List<Integer> menuIds = roleMenuService.findAllByRid(rid)
                .stream().map(RoleMenu::getMid).collect(Collectors.toList());
        List<Menu> menus = menuDao.findAllById(menuIds);

        handleMenus(menus);
        return menus;
    }

    /**
     * Adjust the Structure of the menu.
     *
     * @param menus Menu items list without structure
     */
    public void handleMenus(List<Menu> menus) {
        menus.forEach(m -> {
            List<Menu> children = getAllByParentId(m.getId());
            m.setChildren(children);
        });

        menus.removeIf(m -> m.getParentId() != 0);
    }

    public List<Menu> getAllByParentId(int parentId) {
        return menuDao.findAllByParentId(parentId);
    }
}
