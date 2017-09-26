package com.company.entity;

/**
 * Created by Administrator on 2017/5/22.
 */
public class RolePermission {

    private Long roleId;
    private Long permissionId;

    @Override
    public String toString() {
        return "RolePermission{" +
                "roleId=" + roleId +
                ", permissionId=" + permissionId +
                "}";
    }

    @Override
    public int hashCode() {
        int result = roleId!=null ? roleId.hashCode() : 0;
        result = 31*result + (permissionId!=null ? permissionId.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj==null || this.getClass()!=obj.getClass()) return false;

        RolePermission rolePermission = (RolePermission) obj;

        if(permissionId!=null ? !permissionId.equals(rolePermission.permissionId) : rolePermission.permissionId!=null) return false;
        if(roleId!=null ? !roleId.equals(rolePermission.roleId) : rolePermission.roleId!=null) return false;

        return true;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }
}
