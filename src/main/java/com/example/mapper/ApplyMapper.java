package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Apply;
import com.example.pojo.Goods;
import com.example.pojo.RecordResult;
import com.example.pojo.RecordSelectBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jobob
 * @since 2023-08-08
 *
 */
@Mapper
public interface ApplyMapper extends BaseMapper<Apply> {

    List<RecordResult> list();

    List<RecordResult> listSome(RecordSelectBean selectBean);
}
