package com.company.realm;

import com.company.BaseTest;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2017/5/24.
 */
public class UserRealmTest extends BaseTest {

    @Test
    public void testLoginSuccess() {
        login("classpath:shiro.ini",u1.getUsername(),password);
        Assert.assertTrue(subject().isAuthenticated());
    }

    @Test(expected = LockedAccountException.class)
    public void testLoginFailWithLocked() {
        login("classpath:shiro.ini",u4.getUsername(),password);
    }

    @Test(expected = ExcessiveAttemptsException.class)
    public void testLoginFailWithLimitRetryCount() {

        for(int i=1; i<=5; i++) {
            try {
                login("classpath:shiro.ini",u3.getUsername(),password+"1");
            } catch (Exception e) {

            }
        }
        login("classpath:shiro.ini",u3.getUsername(),password+"1");
        //需要清空缓存，否则后续的执行就会遇到问题
    }

    @Test
    public void testHasRole() {
        //之前ServiceTest解除了zhang-admin
        login("classpath:shiro.ini",u1.getUsername(),password);
        Assert.assertTrue(subject().hasRole("admin"));
    }

    @Test
    public void testNoRole() {
        login("classpath:shiro.ini", u2.getUsername(), password);
        Assert.assertFalse(subject().hasRole("admin"));
    }

    @Test
    public void testHasPermission() {
        login("classpath:shiro.ini", u1.getUsername(), password);
        Assert.assertTrue(subject().isPermittedAll("user:create", "menu:create"));
    }

    @Test
    public void testNoPermission() {
        login("classpath:shiro.ini", u2.getUsername(), password);
        Assert.assertFalse(subject().isPermitted("user:create"));
    }


}
