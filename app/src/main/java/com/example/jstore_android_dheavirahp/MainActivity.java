package com.example.jstore_android_dheavirahp;

import android.app.ExpandableListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Supplier> listSupplier = new ArrayList<>();
    private ArrayList<Item> listItem = new ArrayList<>();
    private HashMap<Supplier, ArrayList<Item>> childMapping = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        protected void refreshList(){
            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray jsonResponse = new JSONArray(response);

                        for (int i = 0; i < jsonResponse.length(); i++) {
                            JSONObject item = jsonResponse.getJSONObject(i);
                            JSONObject tempsupplier = item.getJSONObject("supplier");
                            JSONObject templocation = tempsupplier.getJSONObject("location");

                            int tempItemId = item.getInt("id");
                            String tempItemName = item.getString("Nama");
                            String tempStatusItem = item.getString("status");
                            int tempPrice = item.getInt("price");
                            Supplier tempSupplierItem = (Supplier) item.get("supplier");
                            String tempCategory = item.getString("category");

                            listItem.add(new Item(tempItemId, tempItemName, tempStatusItem, tempPrice, tempSupplierItem, tempCategory));

                            int tempSupplierId = tempsupplier.getInt("id");
                            String tempSupplierName = tempsupplier.getString("name");
                            String tempSupplierEmail = tempsupplier.getString("email");
                            String tempSupplierPhonenumber = tempsupplier.getString("phoneNumber");
                            Location tempSupplierLocation = (Location) tempsupplier.get("location");

                            listSupplier.add(new Supplier(tempSupplierId, tempSupplierName, tempSupplierEmail, tempSupplierPhonenumber, tempSupplierLocation));

                            childMapping.put(listSupplier.get(i), listItem);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };
        }
    }
