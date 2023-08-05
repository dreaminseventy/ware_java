package com.example.controller;


import com.example.pojo.*;
import com.example.service.GoodsService;
import com.example.service.GoodstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2023-08-05
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Goods goods){
        return goodsService.save(goods)?Result.success():Result.fail();
    }

    //修改
    @PutMapping("/update")
    public Result update(@RequestBody Goods goods){
        return goodsService.updateById(goods)?Result.success():Result.fail();
    }

    //删除
    @DeleteMapping("/delete")
    public Result delete(Integer id){
        return goodsService.removeById(id)?Result.success():Result.fail();
    }

    //通过账号来查询
    @GetMapping("/findByName")
    public Result findByAccount(@RequestParam String name){
        List<Goods> list =  goodsService.lambdaQuery().eq(
                Goods::getName,name).list();
        return list.size()>0?Result.success(list):Result.fail();
    }


    //分页按需查询(包含account，sex，name,还有roleId)
    @PostMapping("/list1")
    public Result list1(@RequestBody SelectBean selectBean){
        PageBean pageBean =
        goodsService.listSome(selectBean);
        return Result.success(pageBean.getTotal(),pageBean.getRows());
    }
    @GetMapping("/find")
    public Result find(@RequestParam String name,@RequestParam String storage,@RequestParam String goodstype){
        System.out.println(name+storage+goodstype);
       List<Goods> goodsList = goodsService.find(name,storage,goodstype);
        return Result.success(goodsList);
    }


    //分页查询
    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "5") Integer pageSize){
        PageBean pageBean =  goodsService.dividePage(pageNum,pageSize);;
        return Result.success(pageBean.getTotal(),pageBean.getRows());
    }
}
