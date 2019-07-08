package com.oa.cis.mapper;

import com.oa.cis.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    /**
     * 根据用户名查询密码
     *
     * @param username
     * @return
     */
    String selectPasswordByUsername(@Param("username") String username);

    /**
     * 根据用户名称和密码查询用户
     *
     * @param username
     * @param password
     * @return
     */
    Integer selectUserameAndPassWord(@Param("username") String username, @Param("password") String password);

    /**
     * 用户注册
     *
     * @param userVo
     * @return
     */
    Integer insertUserInfo(UserVo userVo);


    /**
     * 根据用户名修改密码
     *
     * @param username
     * @return
     */
    Integer updatePasswordByUsername(@Param("username") String username, @Param("password") String password);
}