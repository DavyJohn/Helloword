package com.example.helloword.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.helloword.entity.User;
import com.example.helloword.mapper.UserMapper;
import com.example.helloword.mapper.UserMapperP;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserMapperP userMapperP;

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


    /*数据库部分内容*/
    @ApiOperation("查询数据库user")
    @GetMapping(value = "/user/getdbuser",produces = "application/json; charset=utf-8")
    public List<User>  getdbuser(){
        /*不采用mybatisplus*/
//        List<User> users = userMapper.findUser();
        /*采用mybatisplus*/
        List<User> users = userMapperP.selectList(null);
        return users;
    }


    @ApiOperation("插入user")
    @PostMapping(value = "/user/saveuser",produces = "application/json; charset=utf-8")
    public String saveuser(User user){
//        System.out.println(user);
        int num = userMapper.insert(user);
        if (num > 0){
            return "插入成功";
        }else {
            return "插入失败";
        }
//        return "插入成功";
    }

    @ApiOperation("通过id查找user")
    @PostMapping(value = "/user/getuserbyid" ,produces = "application/json; charset=utf-8")
    public User getuserbyid(int id){
        System.out.println(id+"");
        User user = userMapper.finduserbyid(id);
        return user;
    }
    @ApiOperation("通过id删除user")
    @PostMapping(value = "/user/delete" ,produces = "application/json; charset=utf-8")
    public String deleteuserbyid(int id){
        int i = userMapper.delete(id);
        if (i>0){
            return "删除成功";
        }else {
            return "删除失败";
        }
    }
    @ApiOperation("通过id更新数据")
    @PostMapping(value = "/user/updateuser",produces = "application/json; charset=utf-8")
    public String updateuser(User user){
        int  num = userMapper.updateUser(user);
        if (num >0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }
    /*分页处理查找user*/
    @GetMapping(value = "/user/findbypage",produces = "application/json; charset=utf-8")
    @ApiOperation("将数据分页显示")
    public IPage<User> findByPage(){
        Page<User> page = new Page<>(0,2);
        IPage<User> iPage = userMapperP.selectPage(page,null);
        return iPage;

    }
}
