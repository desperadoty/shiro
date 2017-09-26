package com.company.service;

import com.company.entity.Permission;

/**
 * Created by Administrator on 2017/5/23.
 */
public interface PermissionService {

    /**
     * 添加权限
     * @param permission
     * @return
     */
    public Permission createPermission(Permission permission);

    /**
     * 移除权限
     * @param permissionId
     */
    public void deletePermission(Long permissionId);

}
