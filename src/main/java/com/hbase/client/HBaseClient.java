package com.hbase.client;

import com.hbase.article.Article;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Result;

/**
 *
 * @author chandeep
 */
public class HBaseClient {

  
    public ArrayList<Article> selectRowKey(String tableName, String rowKey) throws IOException {
       
        HBaseConnection obj = new HBaseConnection();
        Configuration conf = obj.hbaseConf();
        HTable table = new HTable(conf, tableName);

        ArrayList <com.hbase.article.Article> articles = new ArrayList<>();
        
        Get g = new Get(rowKey.getBytes()); 
        Result rs = table.get(g); 
 
        for (Cell kv : rs.raw()) 
        { 
            articles.add(new Article(new String(kv.getRow()), new String(kv.getFamily()), new String(kv.getQualifier()), new String(kv.getValue())));
        }
        
        return articles;
    }
}
