package com.haojiabao.weixin.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.util.Map;

@Service
public interface WeChatService {
    /**
     * 接受用户(文字)消息
     * @param request 用户消息请求
     * @param response 用户消息回应
     * @return 消息内容
     */
    @Transactional
    public Map<String, String> getMessage(HttpServletRequest request, HttpServletResponse response);

    /**
     * 回复用户文字
     * @param content 回复内容
     * @param map 接受消息封装
     * @return 回复内容xml
     */
    @Transactional
    public String outMessage(String content,Map<String,String> map);
}
