package com.qax.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName User
 * @author Guoqing.Qin
 * @create 2021-01-05 19:40
 * @Description:
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Integer id;

    private String username;

    private Integer num;

    private static final long serialVersionUID = 1L;
}