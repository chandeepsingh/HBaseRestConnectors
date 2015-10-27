package com.hbase.rest.controller;

import com.hbase.article.Article;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.restexpress.Request;
import org.restexpress.Response;

import java.io.IOException;


public class Controller
{
	public Controller()
	{
		super();
	}

	public String create(Request request, Response response)
	{
		//TODO: Your 'POST' logic here...

		return null;
	}

	public List<Article> read(Request request, Response response) throws IOException
	{
		//TODO: Your 'GET' logic here...
		String tableName = request.getHeader("tableName");
                String articleID = request.getHeader("articleID");

		ArrayList <Article> articles = new ArrayList<>();

                com.hbase.client.HBaseClient obj = new com.hbase.client.HBaseClient();
                articles = obj.selectRowKey(tableName, articleID);
                if(articles.isEmpty())
                {
                    articles.add(new Article("Row", "Key", "Not", "Found"));
                    return articles;
                }
                else
                {
                    return articles;
                }                
	}

	public List<Object> readAll(Request request, Response response)
	{
		//TODO: Your 'GET collection' logic here...
		return Collections.emptyList();
	}

	public void update(Request request, Response response)
	{
		//TODO: Your 'PUT' logic here...
		response.setResponseNoContent();
	}

	public void delete(Request request, Response response)
	{
		//TODO: Your 'DELETE' logic here...
		response.setResponseNoContent();
	}
}
