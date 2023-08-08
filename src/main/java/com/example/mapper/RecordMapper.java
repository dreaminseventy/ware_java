package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.Goods;
import com.example.pojo.Record;
import com.example.pojo.RecordResult;
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
 * @since 2023-08-07
 */
@Mapper
public interface RecordMapper extends BaseMapper<Record> {


    List<RecordResult> list(Integer userId);
    List<RecordResult> list();


    List<RecordResult>listSome(SelectBean selectBean);
}
