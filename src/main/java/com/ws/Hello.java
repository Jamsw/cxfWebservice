package com.ws;

import com.alibaba.fastjson.JSONObject;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by dell on 2017/11/22.
 */
@WebService
public interface Hello {
    @WebMethod
    public String sayHello(String strs);
    @WebMethod
    public JSONObject sayJson(String str);
    @WebMethod
    public String sayJsonStr(String str);
}
