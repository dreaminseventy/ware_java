package com.example.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.RecordMapper;
import com.example.pojo.*;
import com.github.pagehelper.PageHelper;
import com.example.service.RecordService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jobob
 * @since 2023-08-07
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public PageBean listSome(SelectBean selectBean) {
        PageHelper.startPage(selectBean.getPageNum(),selectBean.getPageSize());
        List<RecordResult> list = recordMapper.listSome(selectBean);
        Page<RecordResult> p = (Page<RecordResult>) list;
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public PageBean dividePage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<RecordResult> userList =recordMapper.list();
        Page<RecordResult> p = (Page<RecordResult>) userList;
        return new PageBean(p.getTotal(),p.getResult());
    }
}
