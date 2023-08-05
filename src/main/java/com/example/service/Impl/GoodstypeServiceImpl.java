package com.example.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.GoodstypeMapper;
import com.example.pojo.Goodstype;
import com.example.pojo.PageBean;
import com.example.pojo.SelectBean;
import com.example.pojo.Storage;
import com.example.service.GoodstypeService;
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
public class GoodstypeServiceImpl extends ServiceImpl<GoodstypeMapper, Goodstype> implements GoodstypeService {

    @Autowired
    private GoodstypeMapper goodstypeMapper;
    @Override
    public PageBean listSome(SelectBean selectBean) {
        PageHelper.startPage(selectBean.getPageNum(),selectBean.getPageSize());
        List<Goodstype> list = goodstypeMapper.listSome(selectBean);
        Page<Goodstype> p = (Page<Goodstype>) list;
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public PageBean dividePage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<Goodstype> userList =goodstypeMapper.list();
        Page<Goodstype> p = (Page<Goodstype>) userList;
        return new PageBean(p.getTotal(),p.getResult());
    }
}
