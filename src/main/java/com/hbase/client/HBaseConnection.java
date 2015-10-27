package com.hbase.client;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

/**
 *
 * @author chandeep
 */
public class HBaseConnection {
    public Configuration hbaseConf()
    {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        conf.set("hbase.zookeeper.quorum", "cdh5b-1,cdh5b-2,cdh5b-3");
        conf.set("hbase.master", "cdh5b-1:60000");
        
        return conf;
    }
}
