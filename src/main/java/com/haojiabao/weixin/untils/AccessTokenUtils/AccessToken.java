package com.haojiabao.weixin.untils.AccessTokenUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccessToken {
    /**
     * 获取微信的AccessToken
     * @return
     */
    public static String getAccessToken(){
        String accessToken=null;
        String appid="wx88688baef0f7d653";
        String secret="e079f3ed54d6e8fb9ae4a7b27eaedac9";
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret;
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = okHttpClient.newCall(request);
        try {
            Response response = call.execute();
            //System.out.println(response.body().string());
            JSONObject jo = JSON.parseObject(response.body().string());
            accessToken = jo.getString("access_token");

            System.out.println(accessToken);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accessToken;
    }
}
