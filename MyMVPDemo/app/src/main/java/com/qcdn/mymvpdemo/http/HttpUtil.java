package com.qcdn.mymvpdemo.http;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.BinaryHttpResponseHandler;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * AsyncHttpClient ���ٿ���������
 *
 * @author veidy
 */
public class HttpUtil {
    private static AsyncHttpClient client = new AsyncHttpClient(); // ʵ��������

    private static final String BASE_URL = "http://112.124.120.134/subdomain/8/?url=";

    static {
//        client.addHeader("Content-type", "application/x-www-form-urlencoded");
        client.setTimeout(5000); // �������ӳ�ʱ����������ã�Ĭ��Ϊ10s
        client.addHeader("Charset", "UTF-8");
    }

    /**
     * ***************************** get *******************************************
     */
    // ��һ������url��ȡһ��string����
    public static void get(String urlString, AsyncHttpResponseHandler res) {
        client.get(getAbsoluteUrl(urlString), res);
//        client.get(urlString, res);
    }

    // url���������
    public static void get(String urlString, RequestParams params, AsyncHttpResponseHandler res) {
        client.get(getAbsoluteUrl(urlString), params, res);
    }

    // ������������ȡjson�����������
    public static void get(String urlString, JsonHttpResponseHandler res) {
        // client.get(getAbsoluteUrl(urlString), res);
        client.get(urlString, res);
    }

    // ����������ȡjson�����������
    public static void get(String urlString, RequestParams params, JsonHttpResponseHandler res) {
        client.get(getAbsoluteUrl(urlString), params, res);
        System.out.println(getAbsoluteUrl(urlString));
        String s = client.getUrlWithQueryString(false, getAbsoluteUrl(urlString), params);
        System.out.println("ss==" + s);
    }

    // ��������ʹ�ã��᷵��byte����
    public static void get(String uString, BinaryHttpResponseHandler bHandler) {
        client.get(getAbsoluteUrl(uString), bHandler);
    }

    /**
     * *************************** post *************************************
     */
    // ��һ������url��ȡһ��string����
    public static void post(String urlString, AsyncHttpResponseHandler res) {
//        client.post(urlString, res);
        client.post(getAbsoluteUrl(urlString), res);
        System.out.println("urlString=" + urlString);
    }

    // url���������
    public static void post(String urlString, RequestParams params, AsyncHttpResponseHandler res) {

        client.post(getAbsoluteUrl(urlString), params, res);

    }

    // ������������ȡjson�����������
    public static void post(String urlString, JsonHttpResponseHandler res) {

        client.post(getAbsoluteUrl(urlString), res);

    }

    // ����������ȡjson�����������
    @SuppressWarnings("static-access")
    public static void post(String urlString, RequestParams params, JsonHttpResponseHandler res) {
        System.out.println("��ַ" + client.getUrlWithQueryString(false, getAbsoluteUrl(urlString), params));
        client.post(getAbsoluteUrl(urlString), params, res);
        // client.post(urlString, params, res);

    }

    // ��������ʹ�ã��᷵��byte����
    public static void post(String uString, BinaryHttpResponseHandler bHandler) {

        client.post(getAbsoluteUrl(uString), bHandler);

    }

    public static AsyncHttpClient getClient() {

        return client;
    }


    /**
     * �����ļ�
     *
     * @param uString
     * @param file
     */
    public static void downFile(String uString, FileAsyncHttpResponseHandler file) {
        client.post(uString, file);
    }

    /**
     * �ϴ��ļ�
     *
     * @param uString
     * @param params
     * @param handler
     */
    public static void uploadFile(String uString, RequestParams params, AsyncHttpResponseHandler handler) {
        client.removeAllHeaders();
        client.post(uString, params, handler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }
}
