package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.PageBean;
import com.example.pojo.SelectBean;
import com.example.pojo.User;

//User的Service接口
public interface UserService extends IService<User> {
    //按需查询
    PageBean listSome(SelectBean selectBean);
    //分页查询
    PageBean dividePage(Integer pageNum, Integer pageSize,Integer roleId);
}
