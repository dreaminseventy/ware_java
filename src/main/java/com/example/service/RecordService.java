package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.PageBean;
import com.example.pojo.Record;
import com.example.pojo.SelectBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2023-08-07
 */
public interface RecordService extends IService<Record> {

    PageBean listSome(SelectBean selectBean);

    PageBean dividePage(Integer pageNum, Integer pageSize);
}
