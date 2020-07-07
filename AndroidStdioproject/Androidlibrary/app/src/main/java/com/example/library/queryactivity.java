package com.example.library;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.library.manager.bookDaoManager;
import com.example.library.model.bookmodel;

import android.widget.AdapterView;
import java.util.List;

public class queryactivity extends AppCompatActivity {
    private bookDaoManager mDBManager;
    private bookadpter bookadpter;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);
        mDBManager = new bookDaoManager(this);
        List<bookmodel> dataSource = mDBManager.querybooks();
        listView = (ListView)findViewById(R.id.listview);
        bookadpter = new bookadpter(queryactivity.this, dataSource);
        listView.setAdapter(bookadpter);







    }


}
