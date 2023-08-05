package com.example.controller;


import com.example.pojo.*;
import com.example.service.StorageService;
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
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody Storage storage){
        return storageService.save(storage)?Result.success():Result.fail();
    }

    //修改
    @PutMapping("/update")
    public Result update(@RequestBody Storage storage){
        return storageService.updateById(storage)?Result.success():Result.fail();
    }

    //删除
    @DeleteMapping("/delete")
    public Result delete(Integer id){
        return storageService.removeById(id)?Result.success():Result.fail();
    }

    //通过账号来查询
    @GetMapping("/findByName")
    public Result findByAccount(@RequestParam String name){
        List<Storage> list =  storageService.lambdaQuery().eq(Storage::getName,name).list();
        return list.size()>0?Result.success(list):Result.fail();
    }


    //分页按需查询(包含account，sex，name,还有roleId)
    @PostMapping("/list1")
    public Result list1(@RequestBody SelectBean selectBean){
        PageBean pageBean = storageService.listSome(selectBean);
        return Result.success(pageBean.getTotal(),pageBean.getRows());
    }

    //分页查询
    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "5") Integer pageSize){
        PageBean pageBean =  storageService.dividePage(pageNum,pageSize);;
        return Result.success(pageBean.getTotal(),pageBean.getRows());
    }

}
