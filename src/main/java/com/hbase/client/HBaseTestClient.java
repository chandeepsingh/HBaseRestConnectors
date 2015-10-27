package com.hbase.client;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.KeyValue;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.util.Bytes;

/**
 *
 * @author chandeep
 */
public class HBaseTestClient {

    public static void main(String[] arg) throws IOException {
        //queryEntireTable();
        //getValue();
        selectRowKey();
    }
    
    public static void selectRowKey() throws IOException 
    { 
        
        String tableName = "test";
        String rowKey = "row1";
        
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        conf.set("hbase.zookeeper.quorum", "cdh5b-1,cdh5b-2,cdh5b-3");
        conf.set("hbase.master", "cdh5b-1:60000");

        HTable table = new HTable(conf, tableName);
         
        Get g = new Get(rowKey.getBytes()); 
        Result rs = table.get(g); 
 
        for (Cell kv : rs.raw()) 
        { 
            System.out.println("--------------------" + new String(kv.getRow()) + "----------------------------"); 
            System.out.println("Column Family: " + new String(kv.getFamily())); 
            System.out.println("Column       :" + new String(kv.getQualifier())); 
            System.out.println("value        : " + new String(kv.getValue())); 
        } 
    } 
    
    public static void queryEntireTable() throws IOException
    {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        conf.set("hbase.zookeeper.quorum", "cdh5b-1,cdh5b-2,cdh5b-3");
        conf.set("hbase.master", "cdh5b-1:60000");

        HTable table = new HTable(conf, "test");
        
        try {  
            ResultScanner rs = table.getScanner(new Scan());  
            for (Result r : rs) {  
                System.out.println("rowkey:" + new String(r.getRow()));  
                for (KeyValue keyValue : r.raw()) {  
                    System.out.println(new String(keyValue.getFamily()) + "  " + new String(keyValue.getValue()));  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
    public static void getSingleValue() throws IOException
    {
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        conf.set("hbase.zookeeper.quorum", "cdh5b-1,cdh5b-2,cdh5b-3");
        conf.set("hbase.master", "cdh5b-1:60000");

        HTable tableConn = new HTable(conf, "test");

        byte[] cf = Bytes.toBytes("cf");
        byte[] col = Bytes.toBytes("a");

        Scan scan = new Scan();
        scan.addColumn(cf, col);
        ResultScanner rs = tableConn.getScanner(scan);
        for (Result r = rs.next(); r != null; r = rs.next()) {
            byte[] valueObj = r.getValue(cf, col);
            String value = new String(valueObj);
            System.out.println("Value:" + value);
        }

        tableConn.close();
    }

}
