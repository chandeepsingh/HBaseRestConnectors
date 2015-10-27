package com.hbase.rest;

import org.jboss.netty.handler.codec.http.HttpMethod;
import org.restexpress.RestExpress;

import com.hbase.rest.config.Configuration;

public abstract class Routes {

    public static void define(Configuration config, RestExpress server) {
        server.uri("/{tableName}/{articleID}.{format}", config.getController())
                .method(HttpMethod.GET)
                .name(Constants.Routes.SINGLE_SAMPLE);

    }
}
