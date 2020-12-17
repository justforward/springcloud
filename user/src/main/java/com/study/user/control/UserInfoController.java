package com.study.user.control;

import com.study.common.pojo.UserInfo;
import org.springframework.web.bind.annotation.*;

/**
 * @author wangtan
 * @Date 2020/12/17
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {
    @GetMapping("/info/{id}")
    public UserInfo getUser(@PathVariable("id") Long id){
        UserInfo userInfo=new UserInfo(1L,"user_name"+id,"note_"+id);
        return userInfo;
    }

    @PutMapping("/info")
    public UserInfo putUser(@RequestBody UserInfo userInfo){
        return userInfo;
    }
}
