package com.ws;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * Created by dell on 2017/11/22.
 */
public class MainServer {
    public static void main(String[] args) {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setAddress("http://169.254.188.201:8080/cxf");
        factory.setServiceClass(HelloImpl.class);
        Server server = factory.create();
        server.start();
    }
}
