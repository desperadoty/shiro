package com.company;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;


/**
 * Created by Administrator on 2017/5/20.
 */
public abstract class BaseTest {

    protected void login(String configFile, String username, String password) {
        //1.获取SecurityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);

        //2.获取SecurityManager实例,并绑定给SecurityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3.得到Subject及创建用户名/密码身份验证Token
         Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        subject.login(token);

    }

    public Subject subject() {
        return SecurityUtils.getSubject();
    }

    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();
    }
}
