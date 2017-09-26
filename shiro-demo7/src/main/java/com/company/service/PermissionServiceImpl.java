package com.company.service;

import com.company.dao.PermissionDao;
import com.company.dao.PermissionDaoImpl;
import com.company.entity.Permission;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/23.
 */
@Service
public class PermissionServiceImpl implements PermissionService{

    private PermissionDao permissionDao;

    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }
    /**
     * 添加权限
     * @param permission
     * @return
     */
    public Permission createPermission(Permission permission) {
        return permissionDao.createPermission(permission);
    }

    /**
     * 移除权限
     * @param permissionId
     */
    public void deletePermission(Long permissionId) {
        permissionDao.deletePermission(permissionId);
    }
}
