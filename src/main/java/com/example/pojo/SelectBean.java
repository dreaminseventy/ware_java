package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//按需查询类（包含分页的一部分）
@Data
public class SelectBean {
    static private int page_Num = 1;
    static private int page_Size = 10;
    private String name;
    private int pageNum=page_Num;
    private int pageSize=page_Size;
    private int sex;
    private String account;
    private int roleId;
    private String storage;
    private String goodstype;
}
