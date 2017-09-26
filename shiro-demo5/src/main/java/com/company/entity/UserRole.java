package com.company.entity;

/**
 * Created by Administrator on 2017/5/22.
 */
public class UserRole {

    private Long userId;
    private Long roleId;

    @Override
    public String toString() {
        return "UserRole{" +
                "userId=" + userId +
                ", roleId=" + roleId +
                "}";
    }

    @Override
    public int hashCode() {
        int result = userId!=null ? userId.hashCode() : 0;
        result = 31*result + (roleId!=null ? roleId.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if( obj==null || this.getClass()!=obj.getClass()) return false;

        UserRole userRole = (UserRole) obj;

        if(roleId!=null ? !roleId.equals(userRole.roleId) : userRole.roleId!=null) return false;
        if(userId!=null ? !userId.equals(userRole.userId) : userRole.userId!=null) return false;

        return true;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
