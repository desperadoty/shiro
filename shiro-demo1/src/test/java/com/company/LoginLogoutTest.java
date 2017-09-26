package com.company;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2017/5/12.
 * shiro的第一个demo
 */
public class LoginLogoutTest {

    @Test
    public void testSimpleLoginLogout() {

        //1.获取SecurityManager工厂，此处使用ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //2.得到SecurityManager实例，并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3.得到Subject及创建用户名/密码身份认证Token(即用户身份/凭证)
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("desperado","123");

        try {
            //4.登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5.身份验证失败
        }

        Assert.assertEquals(true, subject.isAuthenticated());//断言用户已经登录

        //6.退出
        subject.logout();
    }

    @Test
    public void testSingleRealm() {
        //1.获取SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");

        //2.得到SecurityManager实例，并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3.得到Subject及创建用户名/密码身份验证Token
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("desperado","123");

        try {
            //4.登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5.身份认证失败
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录

        //6.退出
        subject.logout();
    }

    @Test
    public void testMultiRealm() {

        //1.获取SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-multi-realm.ini");

        //2.获取SecurityManager实例，并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3.得到Subject及创建用户名/密码身份验证Token
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("desperado","123");

        try {
            //4.登录，即身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5.身份认证失败
        }

        Assert.assertEquals(true, subject.isAuthenticated());//断言用户已经登录

        //6.退出
        subject.logout();
    }

    @Test
    public void testJdbcRealm() {

        //1.获取SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");

        //2.得到SecurityManager实例，并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3.得到Subject及创建用户名/密码身份验证Token(即用户身份/凭证)
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("yvette","123456");

        try {
            //4.登录，身份验证
            subject.login(token);
        } catch (AuthenticationException e) {
            //5.身份认证失败
        }

        Assert.assertEquals(true,subject.isAuthenticated());//断言用户已经登录

        //6.退出
        subject.logout();
    }

    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时解除绑定Subject到线程，否则对下次测试造成影响
    }

}
