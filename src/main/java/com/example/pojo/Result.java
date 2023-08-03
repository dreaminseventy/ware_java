package com.example.pojo;

import lombok.Data;

//最终返回给前端的结果类
@Data
public class Result {
    private  int code;//编码
    private String msg;//成功/失败
    private Long total;//总记录数
    private Object data;//数据

    public static  Result result(int code,String msg,Long total,Object data){
        Result res = new Result();
        res.setData(data);
        res.setCode(code);
        res.setMsg(msg);
        res.setTotal(total);
        return res;
    }
    public static Result fail(){
        return result(400,"失败",0L,null);
    }

    public static Result success(){
        return result(200,"成功",0L,null);
    }
    public static Result success(Object data){
        return result(200,"成功",0L,data);
    }
    public static Result success(Long total,Object data){
        return result(200,"成功",total,data);
    }
}
