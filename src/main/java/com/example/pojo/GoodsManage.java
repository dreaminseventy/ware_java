package com.example.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class GoodsManage extends Goods{
    private Integer manage;
    private Integer userid;
    private Integer adminid;
    private LocalDateTime createtime;
}
