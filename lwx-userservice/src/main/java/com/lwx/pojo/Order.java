package com.lwx.pojo;

import lombok.Data;

@Data
public class Order {
    private int Id;
    private String OutTradeNo;
    private int State;
    private String CreateTime;
    private int TotalFee;
    private int VideoId;
    private String VideoTitle;
    private String VideoImg;
    private int UserId;

}
