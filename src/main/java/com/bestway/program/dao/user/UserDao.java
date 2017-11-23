package com.bestway.program.dao.user;

import com.bestway.program.model.dto.user.UserDto;
import org.springframework.stereotype.Repository;

/**
 * 用户
 */
@Repository
public interface UserDao {


    /**
     * 查询用户
     */
    Integer qeuryUser(String mobile);

    void insertUser(UserDto dto);
}
