package com.example.controller;


import com.example.pojo.*;
import com.example.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2023-08-07
 */
@RestController
@RequestMapping("/record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    //分页按需查询(包含account，sex，name,还有roleId)
    @PostMapping("/list1")
    public Result list1(@RequestBody SelectBean selectBean){
        PageBean pageBean = recordService.listSome(selectBean);
        return Result.success(pageBean.getTotal(),pageBean.getRows());
    }

    //分页查询
    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "5") Integer pageSize){
        PageBean pageBean = recordService.dividePage(pageNum,pageSize);;
        return Result.success(pageBean.getTotal(),pageBean.getRows());
    }

    //添加记录
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody GoodsManage goodsManage){
        Record record = new Record();
        record.setName(goodsManage.getName());
        record.setAdminid(goodsManage.getAdminid());
        record.setUserid(goodsManage.getUserid());
        record.setCount(goodsManage.getCount());
        record.setRemark(goodsManage.getRemark());
        record.setCreatetime(LocalDateTime.now());
        return recordService.save(record)?Result.success():Result.fail();
    }

}
