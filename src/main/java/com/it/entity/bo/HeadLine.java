package com.it.entity.bo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName: HeadLine
 * @Description:
 * @Author: Du
 * @Date: 2022/6/16
 */
@Data
public class HeadLine {
    private Long lineId;
    private String lineName;
    private  String lineLink;
    private String lineImg;
    private Integer priority;
    private Integer enableStatus;
    private Date createTime;
    private Date lastEditTime;
}
