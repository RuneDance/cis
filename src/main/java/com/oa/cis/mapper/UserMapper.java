package com.oa.cis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {


    /**
     * 根据用户名称和密码查询用户
     *
     * @param username
     * @param password
     * @return
     */
    Integer selectUserameAndPassWord(@Param("username") String username, @Param("password") String password);

}