package com.study.fund.control;

import com.study.common.pojo.UserInfo;
import com.study.fund.facade.UserFacada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangtan
 * @Date 2020/12/17
 */
@RestController
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    private UserFacada userFacada=null;

    @GetMapping("/user/{id}")
    public UserInfo getUser(@PathVariable("id") Long id){
        UserInfo user=userFacada.getUser(id);
        return user;
    }

    @GetMapping("/user/{id}/{userName}/{note}")
    public UserInfo updateUser(@PathVariable("id") Long id,
                               @PathVariable("userName")String userName,
                               @PathVariable("note")String note){
        UserInfo user=new UserInfo(id,userName,note);
        return userFacada.putUser(user);
    }
}
