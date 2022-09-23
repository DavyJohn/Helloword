package com.example.helloword.controller;

import com.example.helloword.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


//如果请求的页面数据使用@Controller注解；如果只是请求数据@RestController  了解
/*重点是@RestController
* 此注解会将返回的对象数据转换为json数据
* */
/*
* @RequestMapping路由映射
* 常用参数
* value:请求Url的路径，支持url模板、正则表达式
* method:http请求方式
* */

@RestController
public class HelloController {
//    @GetMapping("/hello") 等价于下面的写法
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(String name ){
        return "Hello World！"+name;
    }
    /*
    * 如何参数名称是系统参数的名称我们需要采用RequestParam注解
    * name跟nickname就绑定了
    * required = false  不必传，不写就是必穿
    * */

    @RequestMapping(value = "/demo1",method = RequestMethod.GET)
    public String say1(@RequestParam(value = "name",required = false) String nickname){
        return nickname+"hello 你好";

    }

    @RequestMapping(value = "/demo2",method = RequestMethod.POST)
    public String say2(String name ,int age){
        System.out.println(name);
        System.out.println(age+"");
        return "获取到post请求";
    }

    /*
    *
    * 传输一个对象到后台
    * */
    @RequestMapping(value = "/demo3",method = RequestMethod.POST)
    public String say(User user){
        System.out.println(user.getName());
        System.out.println(user.getAge());
        return "传输对象成功";
    }

    /*
    * 传递一个json数据到后台
    * */

    @RequestMapping(value = "/demo4",method = RequestMethod.POST)
    public String say4(@RequestBody User user){
        System.out.println(user.getName());
        System.out.println(user.getAge());
        return "传输对象成功";
    }
}
