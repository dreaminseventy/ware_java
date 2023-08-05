package com.example.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.GoodsMapper;
import com.example.pojo.Goods;

import com.example.pojo.PageBean;
import com.example.pojo.SelectBean;
import com.example.service.GoodsService;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public PageBean listSome(SelectBean selectBean) {
        PageHelper.startPage(selectBean.getPageNum(),selectBean.getPageSize());
        List<Goods> list = goodsMapper.listSome(selectBean);
        Page<Goods> p = (Page<Goods>) list;
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public PageBean dividePage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<Goods> userList =goodsMapper.list();
        Page<Goods> p = (Page<Goods>) userList;
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public List<Goods> find(String name, String storage, String goodstype) {
        return goodsMapper.find(name,storage,goodstype);
    }
}
