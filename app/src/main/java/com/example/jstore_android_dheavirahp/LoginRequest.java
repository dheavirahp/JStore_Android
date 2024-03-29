package com.example.jstore_android_dheavirahp;

import android.app.AlertDialog;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginRequest extends StringRequest
{
    private static final String Regis_URL = "http://10.0.2.2/logincust";
    private Map<String, String> params;

    public LoginRequest(String email, String password,
                        Response.Listener<String> listener)
    {
        super(Method.POST, Regis_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams()
    {
        return  params;
    }
}