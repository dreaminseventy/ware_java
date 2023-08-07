package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.SelectBean;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//mapper接口
@Mapper
public interface UserMapper extends BaseMapper<User> {
    //数据过多使用xml配置（按需查询）
    List<User> listSome(SelectBean selectBean);

    //分页查询
    @Select("select * from warehouse.user where role_id=#{roleId}")
    List<User> list(Integer roleId);


    @Select("select * from warehouse.user")
    List<User> list2();
}
