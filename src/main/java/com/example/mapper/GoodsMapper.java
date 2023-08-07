package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Goods;
import com.example.pojo.SelectBean;
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
public interface GoodsMapper extends BaseMapper<Goods> {

    @Select("select * from warehouse.goods")
    List<Goods> list();

    List<Goods> listSome(SelectBean selectBean);
}
