package com.company.service;

import com.company.dao.RoleDao;
import com.company.dao.RoleDaoImpl;
import com.company.entity.Role;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/5/23.
 */
@Service
public class RoleServiceImpl implements RoleService {

    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }
    /**
     * 添加角色
     * @param role
     * @return
     */
    public Role createRole(Role role) {
        return roleDao.createRole(role);
    }

    /**
     * 移除角色
     * @param roleId
     */
    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    /**
     * 添加角色-权限之间的关系
     * @param roleId
     * @param permissionIds
     */
    public void correlationPermissions(Long roleId, Long... permissionIds) {
        roleDao.correlationPermissions(roleId, permissionIds);
    }

    /**
     * 移除角色-权限之间的关系
     * @param roleId
     * @param permissionIds
     */
    public void uncorrelatonPermissions(Long roleId, Long... permissionIds) {
        roleDao.uncorrelationPermissions(roleId, permissionIds);
    }
}
