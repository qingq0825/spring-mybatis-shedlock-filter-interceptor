package com.qax.service;

import com.github.pagehelper.PageInfo;
import com.qax.model.User;

import java.util.List;

/**
 * @author Guoqing.Qin
 * @ClassName UserService
 * @create 2021-01-05 19:40
 * @Description:
 */

public interface UserService {


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> findByAll(User user);

    PageInfo<User> findByAllwithPage(int page, int pageSize, User user);
}
