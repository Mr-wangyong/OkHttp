package com.mr.wang.okhttp;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;


/**
 * OkHttp学习  来自张鸿洋博客http://blog.csdn.net/lmj623565791/article/details/47911083
 * User: chengwangyong(chengwangyong@vcinema.com)
 * Date: 2015-09-03
 * Time: 23:37
 */
public class OkHttp {
    /**
     * Get请求
     */
    public void getRequest(){
        String url="https://github.com/hongyangAndroid";
        //创建OkHttpClint对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //创建request对象
        Request request = new Request.Builder().url(url).build();
        //通过request的对象去构造得到一个Call对象 类似于将你的请求封装成了任务，既然是任务，就会有execute()和cancel()等方法。
        Call call = okHttpClient.newCall(request);
        //请求加入调度 以异步的方式
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {

            }
        });



    }
}  
