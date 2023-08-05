package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.PageBean;
import com.example.pojo.SelectBean;
import com.example.pojo.Storage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2023-08-05
 */
public interface StorageService extends IService<Storage> {

    PageBean listSome(SelectBean selectBean);

    PageBean dividePage(Integer pageNum, Integer pageSize);
}
