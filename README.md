# shiro
Subject ：主体
Realm：验证主体的数据源

Authentication :
身份认证/登录，验证用户是不是拥有相应的身份

用户需要提供principals （身份）和credentials （证明）给shiro ，从而应用能验证用户身份

一个主体可以有多个principals ，但只有一个primary principals ，一般是用户名／密码／手机号。

Authorization :
授权，即权限验证，验证某个已认证的用户是否拥有某个权限；即判断用户是否能做事情，常见的如：验证某个用户是否拥有某个角色。或者细粒度的验证某个用户对某个资源是否具有某个权限。

基于角色的访问控制（隐式角色）
基于资源的访问控制（显示角色）
