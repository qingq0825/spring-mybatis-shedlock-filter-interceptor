package com.qax.service;

import com.github.pagehelper.PageInfo;
import com.qax.model.Persion;

/**
 * @author Guoqing.Qin
 * @ClassName PersionService
 * @create 2021-01-05 18:56
 * @Description:
 */

public interface PersionService {


    int deleteByPrimaryKey(Integer id);

    int insert(Persion record);

    int insertSelective(Persion record);

    Persion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Persion record);

    int updateByPrimaryKey(Persion record);

    PageInfo<Persion> findByAllwithPage(int page, int pageSize);
}


