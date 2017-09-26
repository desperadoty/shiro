package com.company.dao;

import com.company.entity.Permission;

/**
 * Created by Administrator on 2017/5/22.
 */
public interface PermissionDao {

    Permission createPermission(Permission permission);

    void deletePermission(Long permissionId);

}
