package com.company.dao;

import com.company.entity.Role;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Administrator on 2017/5/22.
 */
@Repository
public class RoleDaoImpl extends JdbcDaoSupport implements RoleDao {

    public Role createRole(final Role role) {

        final String sql = "insert into sys_roles(role, description, available) values(?,?,?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        getJdbcTemplate().update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement stmt = connection.prepareStatement(sql, new String[] { "id" });
                stmt.setString(1, role.getRole());
                stmt.setString(2, role.getDescription());
                stmt.setBoolean(3, role.getAvailable());
                return stmt;
            }
        }, keyHolder);
        role.setId(keyHolder.getKey().longValue());

        return role;
    }

    public void deleteRole(Long roleId) {

        //首先把和role关联的相关表数据删掉
        String sql = "delete from sys_users_roles where role_id=?";
        getJdbcTemplate().update(sql, roleId);

        sql = "delete from sys_roles where id=?";
        getJdbcTemplate().update(sql, roleId);

    }

    private boolean exists(Long roleId, Long permissionId) {
        String sql = "select count(1) from sys_roles_permissions where role_id=? and permission_id=?";
        return getJdbcTemplate().queryForObject(sql, Integer.class, roleId, permissionId) != 0;
    }

    public void correlationPermissions(Long roleId, Long... permissionIds) {

        if(permissionIds == null || permissionIds.length == 0) {
            return;
        }
        String sql = "insert into sys_roles_permissions(role_id, permission_id) values(?,?)";
        for(Long permissionId : permissionIds) {
            if(!exists(roleId, permissionId)) {
                getJdbcTemplate().update(sql, roleId, permissionId);
            }
        }

    }

    public void uncorrelationPermissions(Long roleId, Long... permissionIds) {

        if(permissionIds == null || permissionIds.length == 0) {
            return;
        }
        String sql = "delete from sys_roles_permissions where role_id=? and permission_id=?";
        for(Long permissionId : permissionIds) {
            if(exists(roleId, permissionId)) {
                getJdbcTemplate().update(sql, roleId, permissionId);
            }
        }

    }
}
