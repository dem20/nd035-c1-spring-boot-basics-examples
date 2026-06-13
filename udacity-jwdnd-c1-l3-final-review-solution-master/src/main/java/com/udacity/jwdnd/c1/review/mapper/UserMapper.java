package com.udacity.jwdnd.c1.review.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.udacity.jwdnd.c1.review.model.User;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) " +
            "VALUES (#{username}, #{salt}, #{password}, #{firstname}, #{lastname})")
    @Options(useGeneratedKeys = true, keyProperty = "userid")
    int insert(User user);

    @Select("SELECT userid, username, salt, password, firstname, lastname " +
            "FROM USERS WHERE username = #{username}")
    User getUser(@Param("username") String username);

    @Select("SELECT userid, username, salt, password, firstname, lastname " +
            "FROM USERS WHERE userid = #{userid}")
    User getUserById(@Param("userid") Integer userid);
}