package com.company;

import org.apache.shiro.authz.UnauthorizedException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2017/5/16.
 */
public class PermissionTest extends BaseTest{

    @Test
    public void testIsPermitted() {

        login("classpath:shiro-permission.ini","yvette","123456");

        //判断拥有权限 user:create
        Assert.assertTrue(subject().isPermitted("user:create"));
        //判断拥有权限 user:update and user:delete
        Assert.assertTrue(subject().isPermittedAll("user:update","user:delete"));
        //判断没有权限 user:view
        Assert.assertFalse(subject().isPermitted("user:view"));

    }

    @Test(expected = UnauthorizedException.class)
    public void testCheckPermission() {

        login("classpath:shiro-permission.ini","yvette","123456");

        //断言拥有权限 user:create
        subject().checkPermission("user:create");
        //断言拥有权限 user:delete and user:update
        subject().checkPermissions("user:delete","user:update");
        //断言拥有权限 user:view 失败抛出异常
        subject().checkPermission("user:view");

    }

    @Test
    public void testWildcardPermission1() {

        login("classpath:shiro-permission.ini","justin","123456");

        subject().checkPermissions("system:user:update","system:user:delete");
        subject().checkPermissions("system:user:update,delete");

    }

    @Test
    public void testWildcardPermission2() {

        login("classpath:shiro-permission.ini","justin","123456");

        subject().checkPermissions("system:user:create,update,delete,view");
        subject().checkPermissions("system:user:*");
        subject().checkPermissions("system:user");

    }

    @Test
    public void testWildcardPermission3() {

        login("classpath:shiro-permission.ini","justin","123456");

        subject().checkPermission("user:view");
        subject().checkPermission("system:user:view");

    }

    @Test
    public void testWildcardPermission4() {

        login("classpath:shiro-permission.ini","justin","123456");

        subject().checkPermission("user:view:1");
        subject().checkPermissions("user:delete,update:1");
        subject().checkPermissions("user:delete:1","user:update:1");
        subject().checkPermissions("user:update:1","user:delete:1","user:view:1");
        subject().checkPermissions("user:auth:1","user:auth:2");

    }

    @Test
    public void testWildcardPermission5() {

        login("classpath:shiro-permission.ini","justin","123456");
        subject().checkPermission("menu:view:1");
        subject().checkPermission("organization");
        subject().checkPermission("organization:view:1");

    }
}
