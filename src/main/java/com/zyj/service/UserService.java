package com.zyj.service;

import com.zyj.pojo.User;

public interface UserService {
    //会员注册
    public void saveUser(User user);
    //检查会员账号是否已经存在
    public int checkNo(String no);
    //认证查询
    public User selectUserByUsercode(String usercode);
}
