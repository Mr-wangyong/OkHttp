package com.mr.wang.okhttp;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Get请求
 * User: chengwangyong(chengwangyong@vcinema.com)
 * Date: 2015-09-04
 * Time: 22:03
 */
public class GetExample {
    //初始化一个OkHttpClient
    OkHttpClient client = new OkHttpClient();

    /**
     * Get请求 同步 execute()
     * @param url 地址
     * @return 请求的字符串
     */
    public String run(String url) throws IOException {
        //生成一个request，把url放进去
        Request request = new Request.Builder()
                .url(url)
                .build();
        //执行request，并得到response
        Response response = client.newCall(request).execute();
        //把response中的body转化成string返回
        return response.body().string();
    }

    public static void main(String[] args) throws IOException {
        GetExample example = new GetExample();
        String response = example.run("https://raw.github.com/square/okhttp/master/README.md");
        System.out.println(response);
    }
}  
