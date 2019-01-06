package com.haojiabao.weixin.entity;

import lombok.Data;

@Data
public class Message {
    /**
     * 消息接收方的微信号，一般为公众平台账号微信号
     */
    private String ToUserName;
    /**
     * 消息发送者的openid
     */
    private String FromUserName;
    /**
     * 消息创建时间（整型）
     */
    private Long CreateTime;
    /**
     * 消息类型（text）
     */
    private String MsgType;
    /**
     * 文本消息内容
     */
    private String Content;
    /**
     * 消息id，64位整型
     */
    private String MsgId;
}
