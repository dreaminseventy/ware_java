package com.example.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mapper.ApplyMapper;
import com.example.pojo.*;
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
    public PageBean dividePage(Integer pageNum, Integer pageSize,Integer roleId,Integer userId) {
        PageHelper.startPage(pageNum,pageSize);

        List<RecordResult> userList =applyMapper.list();
        Page<RecordResult> p = (Page<RecordResult>) userList;
        return new PageBean(p.getTotal(),p.getResult());
    }

    @Override
    public PageBean listSome(RecordSelectBean selectBean) {
        PageHelper.startPage(selectBean.getPageNum(),selectBean.getPageSize());
        List<RecordResult> list = applyMapper.listSome(selectBean);
        Page<RecordResult> p = (Page<RecordResult>) list;
        return new PageBean(p.getTotal(),p.getResult());
    }
}
