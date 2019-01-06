package com.haojiabao.controller;

import com.haojiabao.weixin.service.WeChatService;
import com.haojiabao.weixin.untils.AccessTokenUtils.AccessToken;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@RestController
@RequestMapping("/wechat")
public class WeChatController {
    @Resource
    private WeChatService weChatService;
    /**
     * 开发者模式接入
     * @param echostr 随机字符串
     * @return echostr随机字符串
     */
    @GetMapping("/index")
    public String index(@RequestParam("echostr") String echostr){
        return echostr;
    }
    /**
     * 微信接收消息
     * @param request 请求
     * @param response 回应
     * @throws IOException IO异常
     */
    @PostMapping("/index")
    public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String str = null;
        try{
            //用户发送的文字消息
            Map<String,String> strMap=weChatService.getMessage(request,response);
            if(strMap.get("MsgType").equals("text")) {
                System.out.println(strMap.get("Content"));
                str = weChatService.outMessage("你好,"+strMap.get("Content"),strMap);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        out.print(str);
        out.close();
    }

    /**
     * 获取微信accessToken
     * @return 微信accessToken
     */
    @RequestMapping("/accessToken")
    public String accessToken(){
        return AccessToken.getAccessToken();
    }
}
