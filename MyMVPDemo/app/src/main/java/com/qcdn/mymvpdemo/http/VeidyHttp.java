package com.qcdn.mymvpdemo.http;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: http测试
 * Author:veidy
 * Date: 2015-02-28
 * Time: 11:05
 */
public class VeidyHttp {

    public static void HttpPost(String url) {
        BufferedReader in = null;
        try {
            HttpClient client = new DefaultHttpClient();
            HttpPost request = new HttpPost(url);
            //使用NameValuePair来保存要传递的Post参数
            List<NameValuePair> postParameters = new ArrayList<NameValuePair>();
            //添加要传递的参数
            postParameters.add(new BasicNameValuePair("name", "veidy"));
            postParameters.add(new BasicNameValuePair("password", "123456"));
            //实例化UrlEncodedFormEntity对象
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(
                    postParameters);

            //使用HttpPost对象来设置UrlEncodedFormEntity的Entity
            request.setEntity(formEntity);
            HttpResponse response = client.execute(request);
            in = new BufferedReader(
                    new InputStreamReader(
                            response.getEntity().getContent()));

            StringBuffer string = new StringBuffer("");
            String lineStr = "";
            while ((lineStr = in.readLine()) != null) {
                string.append(lineStr + "\n");
            }
            in.close();

            String resultStr = string.toString();
            System.out.println(resultStr);
        } catch (Exception e) {
            // Do something about exceptions
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
