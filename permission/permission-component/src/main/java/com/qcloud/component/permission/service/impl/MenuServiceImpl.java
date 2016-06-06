package com.qcloud.component.permission.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.component.permission.dao.MenuDao;
import com.qcloud.component.permission.dao.PermissionDao;
import com.qcloud.component.permission.model.Menu;
import com.qcloud.component.permission.model.Permission;
import com.qcloud.component.permission.model.query.MenuQuery;
import com.qcloud.component.permission.service.MenuService;
import com.qcloud.component.permission.service.PermissionService;
import com.qcloud.pirates.data.Page;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao           menuDao;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private AutoIdGenerator   autoIdGenerator;

    private String            key = "permission_menu";

    @Transactional
    @Override
    public boolean add(Menu menu) {

        long id = autoIdGenerator.get(key);
        menu.setId(id);
        if (menuDao.add(menu)) {
            Permission permission = new Permission();
            permission.setName(menu.getName());
            permission.setTargetId(id);
            permission.setType(1);
            permission.setId(id);
            return permissionService.add(permission);
        }
        return false;
    }

    @Override
    public Menu get(Long id) {

        return menuDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return menuDao.delete(id);
    }

    @Transactional
    @Override
    public boolean update(Menu menu) {

        if (menuDao.update(menu)) {
            Permission permission = permissionService.get(menu.getId());
            permission.setName(menu.getName());
            return permissionService.update(permission);
        }
        return false;
    }

    @Override
    public Page<Menu> page(int start, int count) {

        return menuDao.page(start, count);
    }

    @Override
    public List<Menu> list() {

        List<Menu> menuList = menuDao.list();
        Collections.sort(menuList, new MenuComparator());
        return menuList;
    }

    @Override
    public List<Menu> list(long catalogId) {

        List<Menu> menuList = menuDao.list(catalogId);
        Collections.sort(menuList, new MenuComparator());
        return menuList;
    }
    class MenuComparator implements Comparator<Menu> {

        @Override
        public int compare(Menu o1, Menu o2) {

            return o1.getOrder() - o2.getOrder();
        }
    }

    @Override
    public List<Menu> list(List<Long> idList) {

        return menuDao.list(idList);
    }

    @Override
    public Page<Menu> page(MenuQuery query, int start, int count) {

        return menuDao.page(query, start, count);
    }
}
