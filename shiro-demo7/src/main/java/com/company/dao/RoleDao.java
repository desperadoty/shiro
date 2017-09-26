package com.company.dao;

import com.company.entity.Role;

/**
 * Created by Administrator on 2017/5/22.
 */
public interface RoleDao {

    Role createRole(Role role);

    void deleteRole(Long roleId);

    void correlationPermissions(Long roleId, Long... permissionIds);

    void uncorrelationPermissions(Long roleId, Long... permissionIds);

}
