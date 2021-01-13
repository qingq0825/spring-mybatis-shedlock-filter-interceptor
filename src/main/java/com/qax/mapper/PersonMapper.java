package com.qax.mapper;

import com.qax.model.Person;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Guoqing.Qin
 * @ClassName PersonMapper
 * @create 2021-01-05 19:00
 * @Description:
 */
@Mapper
public interface PersonMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     *
     * @return deleteCount
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert record to table
     *
     * @param record the record
     *
     * @return insert count
     */
    int insert(Person record);

    /**
     * insert record to table selective
     *
     * @param record the record
     *
     * @return insert count
     */
    int insertSelective(Person record);

    /**
     * select by primary key
     *
     * @param id primary key
     *
     * @return object by primary key
     */
    Person selectByPrimaryKey(Integer id);

    /**
     * update record selective
     *
     * @param record the updated record
     *
     * @return update count
     */
    int updateByPrimaryKeySelective(Person record);

    /**
     * update record
     *
     * @param record the updated record
     *
     * @return update count
     */
    int updateByPrimaryKey(Person record);

    /**
     * 查询所有
     * @return
     */
   List<Person> findByAll();
}