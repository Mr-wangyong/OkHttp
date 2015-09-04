package com.mr.wang.okhttp;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Post方式
 * User: chengwangyong(chengwangyong@vcinema.com)
 * Date: 2015-09-04
 * Time: 22:08
 */
public class PostExample {
    public static final MediaType JSON= MediaType.parse("application/json; charset=utf-8");

    OkHttpClient client=new OkHttpClient();
    //Post请求的核心方法

    /**
     * Post请求方法 一般就两部分 请求 request 响应 response  构建请求对象 然后newCall即可
     * @param url 地址
     * @param json json
     * @throws IOException 异常
     */
    public String post(String url, String json) throws IOException {
        //创建一个RequestBody对象
        RequestBody body = RequestBody.create(JSON, json);
        //生成一个request，把url和body放进去
        Request request = new Request.Builder().url(url).post(body).build();

        //执行同步请求
        Response response = client.newCall(request).execute();

        //把response中的body转化成string返回
        return response.body().string();
    }

    //模拟一段测试的Json数据
    String bowlingJson(String player1, String player2) {
        return "{'winCondition':'HIGH_SCORE',"
                + "'name':'Bowling',"
                + "'round':4,"
                + "'lastSaved':1367702411696,"
                + "'dateStarted':1367702378785,"
                + "'players':["
                + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
                + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
                + "]}";
    }

    public static void main(String[] args) throws IOException {
        PostExample example = new PostExample();
        String json = example.bowlingJson("Jesse", "Jake");
        String response = example.post("http://www.roundsapp.com/post", json);
        System.out.println("请求结果="+response);
    }
}  
