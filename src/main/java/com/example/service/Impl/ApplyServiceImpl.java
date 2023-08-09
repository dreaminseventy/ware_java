package com.example.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.ApplyMapper;
import com.example.pojo.Apply;
import com.example.pojo.Goods;
import com.example.pojo.PageBean;
import com.example.pojo.RecordSelectBean;
import com.example.service.ApplyService;
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
 * @since 2023-08-08
 */
@Service
public class ApplyServiceImpl extends ServiceImpl<ApplyMapper, Apply> implements ApplyService {

    @Autowired
    private ApplyMapper applyMapper;
    @Override
    public PageBean dividePage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);

        List<Apply> userList =applyMapper.list();
        Page<Apply> p = (Page<Apply>) userList;
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public PageBean listSome(RecordSelectBean selectBean) {
        PageHelper.startPage(selectBean.getPageNum(),selectBean.getPageSize());
        List<Goods> list = applyMapper.listSome(selectBean);
        Page<Goods> p = (Page<Goods>) list;
        return new PageBean(p.getTotal(),p.getResult());
    }
}
