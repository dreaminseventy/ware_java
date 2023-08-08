package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2023-08-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Apply implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 货品名
     */
    private String goods;

    /**
     * 申请人
     */
    @TableField("userId")
    private Integer userid;

    /**
     * 数量
     */
    private Integer count;

    /**
     * 操作时间
     */
    @TableField("createTime")
    private LocalDateTime createtime;

    /**
     * 备注
     */
    private String remark;


}
