package com.haojiabao.weixin.service.serviceImpl;

import com.haojiabao.weixin.entity.Message;
import com.haojiabao.weixin.service.WeChatService;
import com.haojiabao.weixin.untils.MessgaeUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Service
public class WeChatServiceImpl implements WeChatService{
    @Override
    public Map<String, String> getMessage(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = null;
        try {
            map = MessgaeUtils.xmlToMap(request);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    @Override
    public String outMessage(String content,Map<String,String> map) {
        Message message=new Message();
        message.setFromUserName(map.get("ToUserName"));
        message.setToUserName(map.get("FromUserName"));
        message.setContent("您发送的消息是:"+content);
        message.setMsgId(map.get("MsgId"));
        message.setMsgType("text");
        message.setCreateTime(System.currentTimeMillis());
        return MessgaeUtils.objectToXml(message);
    }
}
