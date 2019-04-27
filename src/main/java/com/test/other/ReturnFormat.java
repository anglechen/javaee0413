package com.test.other;

import java.util.HashMap;
import java.util.Map;
//格式化返回客户端数据格式（json）
public class ReturnFormat {
    private static Map<String,String>messageMap = new HashMap<>();
    //初始化状态码与文字说明
    static {
        messageMap.put("0", "");

        messageMap.put("400", "Bad Request!");
        messageMap.put("401", "NotAuthorization");
        messageMap.put("405", "Method Not Allowed");
        messageMap.put("406", "Not Acceptable");
        messageMap.put("500", "Internal Server Error");

    }
    public static String retParam(int status,Object data) {
        OutputJson json = new OutputJson(status, messageMap.get(String.valueOf(status)), data);
        return json.toString();
    }
}