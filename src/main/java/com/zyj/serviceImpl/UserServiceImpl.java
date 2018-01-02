package com.zyj.serviceImpl;

import com.zyj.mapper.UserMapper;
import com.zyj.pojo.User;
import com.zyj.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    //会员注册
    public void saveUser(User user) {
       userMapper.saveUser(user);
    }

    public int checkNo(String no) {
        return  userMapper.checkNo(no);
    }

    public User selectUserByUsercode(String usercode) {

        return userMapper.selectUserByUsercode(usercode);
    }
}
