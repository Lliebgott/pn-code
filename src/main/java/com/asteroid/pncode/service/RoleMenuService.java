package com.asteroid.pncode.service;

import com.asteroid.pncode.dao.RoleMenuDao;
import com.asteroid.pncode.pojo.RoleMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author YuSai
 */
@Service
public class RoleMenuService {

    @Autowired
    RoleMenuDao roleMenuDao;

    public List<RoleMenu> findAllByRid(int rid) {
        return roleMenuDao.findAllByRid(rid);
    }

    public List<RoleMenu> findAllByRid(List<Integer> rids) {
        return roleMenuDao.findAllByRidIn(rids);
    }

    public void save(RoleMenu rm) {
        roleMenuDao.save(rm);
    }

    @Modifying
    @Transactional
    public void updateRoleMenu(int rid, Map<String, List<Integer>> menusIds) {
        roleMenuDao.deleteAllByRid(rid);
        List<RoleMenu> rms = new ArrayList<>();
        for (Integer mid : menusIds.get("menusIds")) {
            RoleMenu rm = new RoleMenu();
            rm.setMid(mid);
            rm.setRid(rid);
            rms.add(rm);
        }
        roleMenuDao.saveAll(rms);
    }
}
