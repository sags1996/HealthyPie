package com.example.ashu.healthypie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class JsonParser {

    static HashMap<String,String>data=new HashMap<>();


    public static HashMap<String,String> getJsonData(String JsonFile){


        try {
            if(JsonFile!=null) {

                JSONObject root = new JSONObject(JsonFile);

                String temp= root.getString("temp");
                String hum= root.getString("hum");

                data.put("temp",temp);
                data.put("hum",hum);



            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    return data;
    }
}
