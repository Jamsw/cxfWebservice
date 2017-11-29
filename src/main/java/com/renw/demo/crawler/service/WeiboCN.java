package com.renw.demo.crawler.service;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.sql.Driver;
import java.util.Set;

/**
 * Created by dell on 2017/11/11.
 */
public class WeiboCN {
    public  static  String getSinaCookie(String username,String password) throws  Exception{

        StringBuilder sb = new StringBuilder();
        HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.INTERNET_EXPLORER);
        driver.setJavascriptEnabled(true);
        driver.get("https://passport.weibo.cn/signin/login");
        driver.executeScript("document.getElementById('loginWrapper').style.display = 'block'");
        WebElement mobile=driver.findElementByCssSelector("input#loginName");
        mobile.sendKeys(username);
        WebElement pass = driver.findElementByCssSelector("input#loginPassword");
        pass.sendKeys(password);
        WebElement submit=driver.findElementByCssSelector("a#loginAction");
        submit.click();
        String result=concatCookie(driver);
        System.out.println("Get Cookie: "+result);
        driver.close();
        if(result.contains("SUB")){
            return  result;
        }
        else{
            throw new Exception("weibo login failer");
        }
    }
    public static String concatCookie(HtmlUnitDriver driver){
        Set<Cookie> cookieSet =driver.manage().getCookies();
        StringBuilder sb=new StringBuilder();
        for(Cookie cookie:cookieSet){
            sb.append(cookie.getName() +"="+cookie.getValue());
        }
        String result=sb.toString();
        return result;
    }
}
