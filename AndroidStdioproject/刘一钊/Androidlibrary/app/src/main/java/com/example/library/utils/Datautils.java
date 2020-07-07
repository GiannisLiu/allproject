package com.example.library.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.EditText;

import com.example.library.model.bookmodel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
//负责将json文件格式的数据源处理成，对应book类的数组格式
public class Datautils {

    public static String getJson(String fileName, Context context) {
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = context.getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static List<bookmodel> getbookmodels (String json){
        List<bookmodel> result = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            for (int i = 0 ; i < jsonArray.length() ; i ++) {
                JSONObject object = jsonArray.getJSONObject(i);
                bookmodel bookmodel = new bookmodel();
                bookmodel.setContent_description(object.getString("content_description"));
                bookmodel.setName(object.getString("name"));
                bookmodel.setAuthor(object.getString("author"));
                bookmodel.setPress(object.getString("press"));
                bookmodel.setDate(object.getString("date"));
                bookmodel.setISBN(object.getString("ISBN"));
                bookmodel.setPage(object.getString("page"));
                bookmodel.setScore(object.getString("score"));
                bookmodel.setPrice(object.getString("price"));
                bookmodel.setLink(object.getString("link"));
                result.add(bookmodel);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return result;
    }


}
