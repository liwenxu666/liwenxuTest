package com.lwx.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private int Id;
    private String Phone;
    private String Pwd;
    private int Sex;
    private String Img;
    private Date CreateTime;
    private int Role;
    private String Username;
    private String Wechat;
}
