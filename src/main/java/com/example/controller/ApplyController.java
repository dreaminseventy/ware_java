package com.example.controller;


import com.example.pojo.PageBean;
import com.example.pojo.RecordSelectBean;
import com.example.pojo.Result;
import com.example.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    //分页查询
    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize){
        PageBean pageBean =  applyService.dividePage(pageNum,pageSize);;
        return Result.success(pageBean.getTotal(),pageBean.getRows());
    }

    //分页按需查询(包含account，sex，name,还有roleId)
    @PostMapping("/list1")
    public Result list1(@RequestBody RecordSelectBean selectBean){
        PageBean pageBean = applyService.listSome(selectBean);
        return Result.success(pageBean.getTotal(),pageBean.getRows());
    }
}
