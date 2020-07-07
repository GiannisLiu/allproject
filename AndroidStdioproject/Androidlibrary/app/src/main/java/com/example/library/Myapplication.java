package com.example.library;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.example.library.model.DaoMaster;
import com.example.library.model.DaoSession;

public class Myapplication extends Application {
    public static DaoSession mdaosession;
    @Override
    public void onCreate() {
        super.onCreate();
        initdb();
    }
    public void initdb()
    {
        DaoMaster.DevOpenHelper devOpenHelper=new DaoMaster.DevOpenHelper(this,"book.db");
        SQLiteDatabase db=devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster=new DaoMaster(db);
        mdaosession=daoMaster.newSession();
    }
}
