package com.study.fund.facade;

import com.study.common.pojo.UserInfo;
import com.study.common.response.ResultMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author wtan
 */
@FeignClient("user") //声明为OpenFegin的客户端，底层将使用Ribbon执行REST风格调用。
public interface UserFacada {
    /**
     * 获取用户信息
     * @param id ———用户编号
     * @return 用户信息
     */
    @GetMapping("/user/info/{id}") //注意方法和注解的对应选择
    public UserInfo getUser(@PathVariable("id")Long id);

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     */
    @PutMapping("/user/info") //注意方法和注解的对应选择
    public UserInfo putUser(@RequestBody UserInfo userInfo);

    /**
     * 根据id数组获取用户列表
     * @param ids
     * @return
     */
    @GetMapping("/user/infoes2")
    public ResponseEntity<List<UserInfo>> findUsers2(@RequestParam("ids") Long[] ids);

    /**
     * 删除用户信息，请求头传参
     * @param id
     * @return
     */
    @DeleteMapping("/user/info")
    public ResultMessage deleteUser(@RequestHeader("id") Long id);

    @RequestMapping(value = "/user/upload",
                    //通过MULTIPART_FORM_DATA_VALUE
            // 说明提交的一个"mediaType/from-data"类型的表单
                    consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResultMessage uploadFile(@RequestPart("file") MultipartFile file);
}
