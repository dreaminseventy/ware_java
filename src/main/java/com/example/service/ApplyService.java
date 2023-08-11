package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.Apply;
import com.example.pojo.PageBean;
import com.example.pojo.RecordSelectBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2023-08-08
 */
public interface ApplyService extends IService<Apply> {

    PageBean dividePage(Integer pageNum, Integer pageSize,Integer roleId,Integer userId);

    PageBean listSome(RecordSelectBean selectBean);
}
