package com.example.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.UserMapper;
import com.example.pojo.PageBean;
import com.example.pojo.SelectBean;
import com.example.pojo.User;
import com.example.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//UserService的实现类
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    //按需查询
    @Override
    public PageBean listSome(SelectBean selectBean) {
        PageHelper.startPage(selectBean.getPageNum(),selectBean.getPageSize());
        List<User> list = userMapper.listSome(selectBean);
        Page<User> p = (Page<User>) list;
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public PageBean dividePage(Integer pageNum, Integer pageSize, Integer roleId) {
        PageHelper.startPage(pageNum,pageSize);

        List<User> userList =userMapper.list(roleId);
        Page<User> p = (Page<User>) userList;
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public PageBean dividePage2(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<User> userList =userMapper.list2();
        Page<User> p = (Page<User>) userList;
        return new PageBean(p.getTotal(),p.getResult());
    }
    //分页查询

}
