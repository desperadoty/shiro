package com.company.service;

import com.company.entity.Role;

/**
 * Created by Administrator on 2017/5/23.
 */
public interface RoleService {

    /**
     * 添加角色
     * @param role
     * @return
     */
    public Role createRole(Role role);

    /**
     * 移除角色
     * @param roleId
     */
    public void deleteRole(Long roleId);

    /**
     * 添加角色-权限之间的关系
     * @param roleId
     * @param permissionIds
     */
    public void correlationPermissions(Long roleId, Long... permissionIds);

    /**
     * 移除角色-权限之间的关系
     * @param roleId
     * @param permissionIds
     */
    public void uncorrelatonPermissions(Long roleId, Long... permissionIds);

}
