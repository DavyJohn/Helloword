package com.example.helloword.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.helloword.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapperP extends BaseMapper<User> {
}
