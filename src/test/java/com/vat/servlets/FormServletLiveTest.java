package com.vat.servlets;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FormServletLiveTest {
    @Test
    public void whenPostRequestUsingHttpClient_thenCorrect()
            throws Exception {

        HttpClient client = new DefaultHttpClient();
        HttpPost method = new HttpPost(
                "");


        List<BasicNameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("sum", String.valueOf(234)));
        nvps.add(new BasicNameValuePair("rate", String.valueOf(.80)));

        method.setEntity(new UrlEncodedFormEntity(nvps));
        HttpResponse httpResponse = client.execute(method);

        assertEquals("Success", httpResponse
                .getHeaders("Test")[0].getValue());
        assertEquals("20.0", httpResponse
                .getHeaders("VAT")[0].getValue());
    }
}
