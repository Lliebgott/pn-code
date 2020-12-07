package com.asteroid.pncode.service;

import com.asteroid.pncode.dao.UserRoleDao;
import com.asteroid.pncode.pojo.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YuSai
 */
@Service
public class UserRoleService {
    @Autowired
    UserRoleDao userRoleDao;

    public List<UserRole> listAllByUid(int uid) {
        return userRoleDao.findAllByUid(uid);
    }

//    @Modifying
    @Transactional
    public void saveRoleChanges(int uid, List<UserRole> roles) {
        userRoleDao.deleteAllByUid(uid);
        List<UserRole> urs = new ArrayList<>();
        roles.forEach(r -> {
            UserRole ur = new UserRole();
            ur.setUid(uid);
            ur.setRid(r.getId());
            urs.add(ur);
        });
        userRoleDao.saveAll(urs);
    }
}
