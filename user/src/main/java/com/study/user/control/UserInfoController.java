package com.study.user.control;

import com.study.common.pojo.UserInfo;
import com.study.common.response.ResultMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/infoes2")
    public ResponseEntity<List<UserInfo>> findUsers2(@RequestParam("ids") Long[] ids){
        List<UserInfo> userInfoList=new ArrayList<>();
        for(Long id:ids){
            UserInfo userInfo=new UserInfo(id,"user_name"+id,"note_"+id);
            userInfoList.add(userInfo);
        }
        ResponseEntity<List<UserInfo>> response=new ResponseEntity<>(userInfoList, HttpStatus.OK);
        return response;
    }
    @DeleteMapping("/info")
    public ResultMessage deleteUser(@RequestHeader("id") Long id){
        boolean success=id!=null;
        String msg=success?"传递成功":"传递失败";
        return new ResultMessage(success,msg);
    }

    @PostMapping("/upload")
    public ResultMessage uploadFile(@RequestPart("file")MultipartFile file){
        boolean success=file!=null&&file.getSize()>0;
        String message=success?"文件传递成功":"文件传递失败";
        return new ResultMessage(success,message);

    }
}
