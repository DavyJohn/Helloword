package com.example.helloword.controller;

import com.example.helloword.entity.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class UserController {
//    @ApiOperation("获取用户通过id")
    /*获取用户通过id*/
    @GetMapping("/user/{id}")
    @ApiOperation("获取用户通过id")
    public String getUserById(@PathVariable int id){
        System.out.println(id+"");
        return "获取id为:" + id;
    }

    /*
    * 添加一个user
    * */
    @ApiOperation("添加一个user")
    @PostMapping("/user/adduser")
    public String addUser(User user){
        System.out.println(user.getName());
        return "创建一个user";
    }

    /*
    * 更新一个用户
    * */
    @ApiOperation("更新一个用户")
    @PutMapping("/user/upuser")
    public String upuser(User user){
        System.out.println(user.getName());
        return "更新user";
    }

    /*删除用户*/
    @ApiOperation("删除用户")
    @DeleteMapping("/user/deletesser/{id}")
    public String deleteUser(@PathVariable int id){
        return "删除用户id为"+id+"的用户";
    }


}
