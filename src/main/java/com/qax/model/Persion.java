package com.qax.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @ClassName Persion
 * @author Guoqing.Qin
 * @create 2021-01-05 19:00
 * @Description:
 *
 */
@Data
@AllArgsConstructor
public class Persion {
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