package com.company;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2017/5/20.
 */
public class IniMainTest {

    @Test
    public void test() {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-config-main.ini");

        SecurityManager securityManager = factory.getInstance();

        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken("yvette","123456");

        subject.login(token);

        Assert.assertTrue(subject.isAuthenticated());
    }
}
