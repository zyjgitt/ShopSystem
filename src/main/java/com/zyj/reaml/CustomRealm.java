package com.zyj.reaml;

import com.zyj.pojo.User;
import com.zyj.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

public class CustomRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证");
        String usercode = token.getPrincipal().toString();
        System.out.println(usercode);

        User user = userService.selectUserByUsercode(usercode);
        System.out.println("user::"+user);
       if(user==null){
          return null;
       }
        Subject subject = SecurityUtils.getSubject();

        Session session = subject.getSession();
        session.setAttribute("user",user);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user,user.getPassword(), ByteSource.Util.bytes(user.getSalt()),this.getName());
        System.out.println(user);
        return  info;
    }
}
