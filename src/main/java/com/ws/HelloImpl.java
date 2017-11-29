package com.ws;

import com.alibaba.fastjson.JSONObject;

import javax.jws.WebService;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2017/11/22.
 */
@WebService(targetNamespace="http://ws.com/",endpointInterface = "com.ws.Hello")
public class HelloImpl implements Hello {
    @Override
    public String sayHello(String str) {
        System.out.println("web services调用成功");
        String result = createXml(str);
        return result;
    }

    @Override
    public JSONObject sayJson(String str) {
        return createJsonObject(str);
    }

    @Override
    public String sayJsonStr(String str) {
        return createJsonObject(str).toString();
    }
    /**
     * 创建JsonOBject对象
     *
     * @return 返回jsonObject对象
     */
    public JSONObject createJsonObject(String name) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "liqineng");
        String[] likes = new String[] { "music", "movie", "study" };
        jsonObj.put("hobby", likes);
        Map<String, String> ingredients = new HashMap<String, String>();
        ingredients.put("age", "23");
        ingredients.put("EnglishName", "spider man");
        ingredients.put("sex", "boy");
        ingredients.put("love", "tangwei");
        jsonObj.put("message", ingredients);
        return jsonObj;
    }
    /**
     * 根据传递的字符串生成对应的xml。
     *
     * @param name
     * @return 返回xml的字符串
     */
    public String createXml(String name) {

        StringBuffer sb = new StringBuffer();
        sb.append("<?xml version='1.0' encoding='UTF-8'?>");
        sb.append("<Result>");
        sb.append("<cinamaName>机械战警</cinamaName>");
        sb.append("<director>" + name + "</director>");
        sb.append("<introduce>一部好莱坞大片，3D观影，不错！！！</introduce>");
        sb.append("<price>25</price>");
        sb.append("</Result>");
        return sb.toString();
    }
}
