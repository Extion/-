package com.mapper;

import com.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    //登录
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User login(@Param("username") String username, @Param("password") String password);

    //添加用户
    @Insert("insert into tb_user values(null,#{username},#{password})")
    void selectAdd(User user);

    //检查用户是否存在
    @Select("select * from tb_user where username = #{username}")
    User register(@Param("username") String username);
}
