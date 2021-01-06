package com.qax.controller;

import com.github.pagehelper.PageInfo;
import com.qax.model.User;
import com.qax.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Guoqing.Qin
 * @ClassName UserController
 * @create 2021-01-05 19:56
 * @Description:
 */
@RequestMapping("/user")
@RestController
@SuppressWarnings("ALL")
public class UserController {
    public UserController() {
        super();
    }

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public ResponseEntity index() {
        return new ResponseEntity("Welcome to .....", HttpStatus.OK);
    }

    @GetMapping("/page/{pageNo}/{size}")
    public ResponseEntity page(@PathVariable(value = "pageNo") Integer pageNo,
                               @PathVariable(value = "size") Integer size) {

        PageInfo<User> pageInfo = userService.findByAllwithPage(pageNo, size, null);

        return new ResponseEntity(pageInfo, HttpStatus.OK);

    }
}
