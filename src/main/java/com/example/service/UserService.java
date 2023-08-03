package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.PageBean;
import com.example.pojo.SelectBean;
import com.example.pojo.User;

public interface UserService extends IService<User> {
    PageBean listSome(SelectBean selectBean);

    PageBean dividePage(Integer pageNum, Integer pageSize);
}
