package com.example.controller;


import com.example.pojo.*;
import com.example.service.GoodsService;
import com.example.service.GoodstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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

    //通过名字来查询
    @GetMapping("/findByName")
    public Result findByName(@RequestParam String name){
        List<Goods> list =  goodsService.lambdaQuery().eq(
                Goods::getName,name).list();
        return list.size()>0?Result.success(list):Result.fail();
    }

    //分页按需查询(包含account，sex，name,还有roleId)
    @PostMapping("/list1")
    public Result list1(@RequestBody RecordSelectBean selectBean){
        PageBean pageBean = goodsService.listSome(selectBean);
        return Result.success(pageBean.getTotal(),pageBean.getRows());
    }

    //分页查询
    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "5") Integer pageSize){
        PageBean pageBean =  goodsService.dividePage(pageNum,pageSize);;
        return Result.success(pageBean.getTotal(),pageBean.getRows());
    }

    //入库
    @PostMapping("/storage")
    public Result inStorage(@RequestBody GoodsManage goodsManage){
        Goods goods = goodsService.getById(goodsManage.getId());
        System.out.println(goods);
        return getResult(goodsManage, goods);
    }
    //申请入库
    @PostMapping("/applystorage")
    public Result applyStorage(@RequestBody GoodsManage goodsManage){
        Goods goods = goodsService.getByName(goodsManage.getName());
        return getResult(goodsManage, goods);
    }

    private Result getResult(@RequestBody GoodsManage goodsManage, Goods goods) {
        int oldCount = goods.getCount();
        int newCount;
        if (goodsManage.getManage()==1){
            newCount = oldCount + goodsManage.getCount();
            goods.setCount(newCount);
        }
        else{
            newCount = oldCount - goodsManage.getCount();
            if (newCount<0){
                return Result.fail(goods);
            }
            goods.setCount(newCount);
        }
        goodsService.updateById(goods);
        return Result.success(goods);
    }


}
