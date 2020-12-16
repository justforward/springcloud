package com.study.fund.control;

import com.study.common.response.ResultMessage;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wangtan
 * @Date 2020/12/15
 */
@RestController
@RequestMapping("/fund/")
public class AccountController {

    @PostMapping("account/balance/{userId}/{amount}")
    public ResultMessage deuctingBalance(@PathVariable("userId") Long userId,
                                         @PathVariable("amount") Double amount,
                                         HttpServletRequest request){
        //当前服务的端口用于监听
        String message="端口：【"+request.getServerPort()+"】减扣成功";
        ResultMessage resultMessage=new ResultMessage(true,message);
        return resultMessage;
    }

}
