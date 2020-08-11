package com.dxzmpk.edu_backend.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class CONSTLIST {



    public CONSTLIST constlist;

    public static int OK = 200;
    public static int FAIL = 210;
    public static final String SUCCESS = "10000"; // 成功
    public static final String PAYING  = "10003"; // 用户支付中
    public static final String FAILED  = "40004"; // 失败
    public static final String ERROR   = "20000"; // 系统异常


}
