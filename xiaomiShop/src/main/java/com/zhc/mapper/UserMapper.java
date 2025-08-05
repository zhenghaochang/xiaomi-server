package com.zhc.mapper;

import com.zhc.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from xiaomi.user where username=#{username}")
    User findByUsername(String username);

    @Insert("insert into xiaomi.user (username, password, name) value (#{username},#{password},#{name})")
    void insert(User user);
}
