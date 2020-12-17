package com.study.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wangtan
 * @Date 2020/12/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -552873415095704854L;
    private Long userId;
    private String userName;
    private String note;


}
