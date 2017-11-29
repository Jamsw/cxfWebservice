package com.renw.demo.crawler.service;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.net.HttpRequest;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by dell on 2017/11/11.
 */
public class WeiboCrawler extends BreadthCrawler {

    String cookie;
    public WeiboCrawler(String crawlPath) throws Exception {
        super(crawlPath,false);
        cookie=WeiboCN.getSinaCookie("18604595264@163.com","rwsql19921205222");
        setThreads(10);
        getConf().setExecuteInterval(1000);
    }
    @Override
    public Page getResponse(CrawlDatum crawlDatums) throws Exception {
        HttpRequest request=new HttpRequest(crawlDatums);
        request.setCookie(cookie);
        return request.responsePage();
    }
    @Override
    public void visit(Page page, CrawlDatums next) {
        int pageNum=Integer.valueOf(page.meta("pageNum"));
        Elements weibos=page.select("div.c[id]");
        for(Element weibo:weibos){
            System.out.println("第"+pageNum+"页\t"+weibo.text());
        }
    }

    public static void main(String[] args) throws Exception {
        WeiboCrawler crawler=new WeiboCrawler("crawl_weibo");
        for(int i=1;i<=5;i++){
            String seedUrl="http://weibo.cn/zhouhongyi?vt=4&page=" + i;
            crawler.addSeedAndReturn(seedUrl).meta("pageNum",i);
        }
        crawler.start(1);
    }
}
