package com.study.fund.result.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author wangtan
 * @Date 2020/12/15
 */
@Data
@AllArgsConstructor
public class ResultMessage {
    private boolean success;
    private String message;
}
