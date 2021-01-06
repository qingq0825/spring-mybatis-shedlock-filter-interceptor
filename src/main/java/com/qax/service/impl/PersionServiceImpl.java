package com.qax.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qax.mapper.PersionMapper;
import com.qax.model.Persion;
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
    private PersionMapper persionMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return persionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Persion record) {
        return persionMapper.insert(record);
    }

    @Override
    public int insertSelective(Persion record) {
        return persionMapper.insertSelective(record);
    }

    @Override
    public Persion selectByPrimaryKey(Integer id) {
        return persionMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Persion record) {
        return persionMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Persion record) {
        return persionMapper.updateByPrimaryKey(record);
    }

    /**
     * @param page
     * @param pageSize
     *
     * @return
     */
    public PageInfo<Persion> findByAllwithPage(int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return new PageInfo<>(persionMapper.findByAll());
    }
}


