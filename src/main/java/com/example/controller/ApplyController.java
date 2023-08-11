package com.example.controller;


import com.example.pojo.*;
import com.example.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2023-08-08
 */
@RestController
@RequestMapping("/apply")
public class ApplyController {

    @Autowired
    private ApplyService applyService;
    //分页查询pageBean中封装的是RecordResult类
    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize,
                       @RequestParam Integer roleId,@RequestParam Integer userId

    ){
        PageBean pageBean =  applyService.dividePage(pageNum,pageSize,roleId,userId);;
        return Result.success(pageBean.getTotal(),pageBean.getRows());
    }

    //分页按需查询(包含account，sex，name,还有roleId)pageBean中封装的是RecordResult类
    @PostMapping("/list1")
    public Result list1(@RequestBody RecordSelectBean selectBean){
        PageBean pageBean = applyService.listSome(selectBean);
        return Result.success(pageBean.getTotal(),pageBean.getRows());
    }

    //删除
    @DeleteMapping("/delete")
    public Result delete(Integer id){
        return applyService.removeById(id)?Result.success():Result.fail();
    }
    //新增
    @PostMapping("/save")
    public Result save(@RequestBody GoodsManage goodsManage){
        Apply apply = new Apply();
        apply.setName(goodsManage.getName());
        apply.setUserid(goodsManage.getUserid());
        apply.setCount(goodsManage.getCount());
        apply.setRemark(goodsManage.getRemark());
        apply.setManage(goodsManage.getManage());
        apply.setCreatetime(LocalDateTime.now());
        return applyService.save(apply)?Result.success():Result.fail();
    }


}
