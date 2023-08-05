package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Goodstype;
import com.example.pojo.SelectBean;
import com.example.pojo.Storage;
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
public interface GoodstypeMapper extends BaseMapper<Goodstype> {

    @Select("select * from warehouse.goodstype")
    List<Goodstype> list();

    List<Goodstype> listSome(SelectBean selectBean);
}
