package com.example.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class RecordSelectBean extends SelectBean{
    private String storage;
    private String goodstype;
    private int userId;
}
