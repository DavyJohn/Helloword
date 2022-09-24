package com.example.helloword.mapper;

import com.example.helloword.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*创建一个user接口在里面做数据库的操作*/
@Mapper
public interface UserMapper  {

    /*查询所有用户*/
    @Select("select * from user")
    public List<User> findUser();
    /*查询用户id为？的user*/
    @Select("select * from user where id=#{id}")
    public User finduserbyid(int id);
    /*添加用户*/
    @Insert("insert into user values (#{id},#{name},#{age},#{password})")
    public int insert(User user);
    /*删除操作*/
    @Delete("delete from user where id=#{id}")
    public int delete(int id);
    /*改动数据*/
    @Update("update user set password=#{password},age=#{age},name=#{name} where id=#{id}")
    public int updateUser(User user);

}
