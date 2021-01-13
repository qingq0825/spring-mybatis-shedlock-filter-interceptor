package com.qax.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qax.mapper.PersonMapper;
import com.qax.model.Person;
import com.qax.service.PersionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Guoqing.Qin
 * @ClassName PersionServiceImpl
 * @create 2021-01-05 18:56
 * @Description:
 */

@Service
public class PersionServiceImpl implements PersionService {

    @Resource
    private PersonMapper personMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return personMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Person record) {
        return personMapper.insert(record);
    }

    @Override
    public int insertSelective(Person record) {
        return personMapper.insertSelective(record);
    }

    @Override
    public Person selectByPrimaryKey(Integer id) {
        return personMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Person record) {
        return personMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Person record) {
        return personMapper.updateByPrimaryKey(record);
    }

    /**
     * @param page
     * @param pageSize
     *
     * @return
     */
    public PageInfo<Person> findByAllwithPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(personMapper.findByAll());
    }
}


