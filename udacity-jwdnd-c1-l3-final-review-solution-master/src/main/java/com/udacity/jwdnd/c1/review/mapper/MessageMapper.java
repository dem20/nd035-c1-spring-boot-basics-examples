package com.udacity.jwdnd.c1.review.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.udacity.jwdnd.c1.review.model.ChatMessage;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Insert("INSERT INTO MESSAGES (username, messagetext) " +
            "VALUES (#{username}, #{messagetext})")
    @Options(useGeneratedKeys = true, keyProperty = "messageid")
    int insert(ChatMessage message);

    @Select("SELECT messageid, username, messagetext FROM MESSAGES")
    List<ChatMessage> getAllMessages();

    @Select("SELECT messageid, username, messagetext FROM MESSAGES WHERE messageid = #{messageid}")
    ChatMessage getMessageById(@Param("messageid") Integer messageid);

    @Select("SELECT messageid, username, messagetext FROM MESSAGES WHERE username = #{username}")
    List<ChatMessage> getMessagesByUsername(@Param("username") String username);

    @Delete("DELETE FROM MESSAGES WHERE messageid = #{messageid}")
    int deleteMessage(@Param("messageid") Integer messageid);
}

