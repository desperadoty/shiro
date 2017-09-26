package com.company.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by Administrator on 2017/5/12.
 */
public class MyRealm3 implements Realm {

    public String getName() {
        return "myrealm3";
    }

    public boolean supports(AuthenticationToken token) {
        //仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        if(!"desperado".equals(username)) {
            throw new UnknownAccountException();//如果用户名错误
        }

        if(!"123".equals(password)) {
            throw new IncorrectCredentialsException();//如果密码错误
        }

        //如果身份认证验证成功，返回一个AuthenticationInfo实现
        return new SimpleAuthenticationInfo(username+"@163.com",password,getName());

    }
}
