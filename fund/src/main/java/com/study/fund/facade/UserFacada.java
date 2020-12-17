package com.study.fund.facade;

import com.study.common.pojo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

}
