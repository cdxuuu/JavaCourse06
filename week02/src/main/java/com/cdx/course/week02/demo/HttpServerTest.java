package com.cdx.course.week02.demo;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.InputStream;

public class HttpServerTest {
    /**
     * 写一段代码，使用 HttpClient 或 OkHttp 访问  http://localhost:8801 ，代码提交到 GitHub
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws  Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://localhost:8081");
        CloseableHttpResponse response = httpClient.execute(httpPost);

        int statusCode = response.getStatusLine().getStatusCode();
        if(statusCode == 200) {
            HttpEntity entity = response.getEntity();
            String s = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(s);
        }
    }
}
