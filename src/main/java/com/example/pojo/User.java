package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//主要的User类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @TableId(value="id",type= IdType.AUTO)
    private Integer id;
    private String account;
    private String name;
    private String password;
    private int age;
    private int sex;
    private String phone;
    private int roleId;
    private String isValid;
}
