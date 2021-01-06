package com.qax.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qax.mapper.UserMapper;
import com.qax.model.User;
import com.qax.service.UserService;
import com.qax.util.PageBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Guoqing.Qin
 * @ClassName UserServiceImpl
 * @create 2021-01-05 19:40
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<User> findByAll(User user) {
        return userMapper.findByAll(user);
    }

    @Override
    public PageInfo<User> findByAllwithPage(int page, int pageSize, User user) {
        // 开启分页
        PageHelper.startPage(page, pageSize);
        PageInfo<User> userPageInfo = new PageInfo<>(userMapper.findByAll(user));

        // 组装数据
        PageBean<User> pageData = new PageBean<>(page, pageSize,
                Integer.parseInt(String.valueOf(userPageInfo.getTotal())));
        pageData.setItems(userPageInfo.getList());

        System.out.println("pageData = " + pageData.toString());
        return userPageInfo;
    }
}
