package com.siam.expartvolley;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class VolleyString {
    private String url = "";
    private Context context;
    public interface VolleyCallback{
        void response(String response);
        void error(VolleyError error);
    }
    public void volleyString(String url, Context context, final VolleyCallback callback) {
        this.url = url;
        this.context = context;
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        callback.response(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callback.error(error);
            }
        });

        queue.add(stringRequest);

    }
}
