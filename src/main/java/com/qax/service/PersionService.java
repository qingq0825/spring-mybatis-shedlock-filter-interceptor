package com.qax.service;

import com.github.pagehelper.PageInfo;
import com.qax.model.Person;

/**
 * @author Guoqing.Qin
 * @ClassName PersionService
 * @create 2021-01-05 18:56
 * @Description:
 */

public interface PersionService {


    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);

    PageInfo<Person> findByAllwithPage(int page, int pageSize);
}


