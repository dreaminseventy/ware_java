package com.example.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.StorageMapper;
import com.example.pojo.PageBean;
import com.example.pojo.SelectBean;
import com.example.pojo.Storage;
import com.example.pojo.User;
import com.example.service.StorageService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2023-08-05
 */
@Service
public class StorageServiceImpl extends ServiceImpl<StorageMapper, Storage> implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public PageBean listSome(SelectBean selectBean) {
        PageHelper.startPage(selectBean.getPageNum(),selectBean.getPageSize());
        List<Storage> list = storageMapper.listSome(selectBean);
        Page<Storage> p = (Page<Storage>) list;
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public PageBean dividePage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<Storage> userList =storageMapper.list();
        Page<Storage> p = (Page<Storage>) userList;
        return new PageBean(p.getTotal(),p.getResult());
    }
}
