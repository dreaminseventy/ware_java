package com.example.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RecordResult extends Record{
    private String username;
    private String adminname;
    private String storage;
    private String goodstype;
}
