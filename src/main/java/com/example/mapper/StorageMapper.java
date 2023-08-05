package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.SelectBean;
import com.example.pojo.Storage;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2023-08-05
 */
@Mapper
public interface StorageMapper extends BaseMapper<Storage> {

    @Select("select * from warehouse.storage")
    List<Storage> list();

    List<Storage> listSome(SelectBean selectBean);
}
