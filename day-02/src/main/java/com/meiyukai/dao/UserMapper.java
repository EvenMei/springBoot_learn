package com.meiyukai.dao;

import com.meiyukai.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 查询所有
     * @return
     */
    @Select(value = "select * from user")
    List<User> findAll();

}
