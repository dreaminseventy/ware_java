package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.mapper.UserMapper;
import com.example.pojo.PageBean;
import com.example.pojo.Result;
import com.example.pojo.SelectBean;
import com.example.pojo.User;
import com.example.service.UserService;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //返回所有数据(不分页)
    @GetMapping("/list")
    public Result list(){
        return Result.success(userService.list());
    }

    //新增
    @PostMapping("/save")
    public Result save(@RequestBody User user){
        return userService.save(user)?Result.success():Result.fail();
    }

    //修改
    @PutMapping("/update")
    public Result update(@RequestBody User user){
        return userService.updateById(user)?Result.success():Result.fail();
    }

    //新增或修改
    @PutMapping("/saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody User user){
        return  userService.saveOrUpdate(user);
    }

    //删除
    @DeleteMapping("/delete")
    public Result delete(Integer id){
        return userService.removeById(id)?Result.success():Result.fail();
    }

    //通过账号来查询
    @GetMapping("/findByName")
    public Result findByName(@RequestParam String name){
       List<User> list =  userService.lambdaQuery().eq(User::getName,name).list();
       return list.size()>0?Result.success(list.get(0)):Result.fail();
    }

    //通过账号来查询
    @GetMapping("/findByAccount")
    public Result findByAccount(@RequestParam String account){
        List<User> list =  userService.lambdaQuery().eq(User::getAccount,account).list();
        return list.size()>0?Result.success(list):Result.fail();
    }


    //登录
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        List<User> list = userService.lambdaQuery()
                .eq(User::getAccount,user.getAccount())
                .eq(User::getPassword,user.getPassword())
                .list();
        return list.size()>0?Result.success(list.get(0)):Result.fail();
    }

    //查询（模糊匹配未使用）
    @PostMapping("listAll")
    public  Result listAll(@RequestBody User user){
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        if (StringUtils.isNotBlank(user.getName()))
            lambdaQueryWrapper.like(User::getName,user.getName());
        return Result.success(userService.list(lambdaQueryWrapper));
    }

    //分页按需查询(包含account，sex，name,还有roleId)
    @PostMapping("/list1")
    public Result list1(@RequestBody SelectBean selectBean){
        PageBean pageBean = userService.listSome(selectBean);
        return Result.success(pageBean.getTotal(),pageBean.getRows());
    }


    //分页查询
    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "5") Integer pageSize,
                       @RequestParam Integer roleId){
        PageBean pageBean =  userService.dividePage(pageNum,pageSize,roleId);;
        return Result.success(pageBean.getTotal(),pageBean.getRows());
    }

    //分页查询
    @GetMapping("/page2")
    public Result page2(@RequestParam(defaultValue = "1") Integer pageNum,@RequestParam(defaultValue = "5") Integer pageSize){
        PageBean pageBean =  userService.dividePage2(pageNum,pageSize);;
        return Result.success(pageBean.getTotal(),pageBean.getRows());
    }
}
