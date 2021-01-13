package com.qax.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Guoqing.Qin
 * @ClassName Person
 * @create 2021-01-05 19:00
 * @Description: 人
 */
@Data
@AllArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = 5954809042643762884L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 角色账户
     */
    private String roleAcc;

    /**
     * 角色代码
     */
    private String roleCode;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 创建时间
     */
    private Date dateCreated;
}