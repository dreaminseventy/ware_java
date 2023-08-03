package com.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class SelectBean {
    static private int page_Num = 1;
    static private int page_Size = 10;
    private String name;
    private int pageNum=page_Num;
    private int pageSize=page_Size;
    private int sex;
    private String account;
}
