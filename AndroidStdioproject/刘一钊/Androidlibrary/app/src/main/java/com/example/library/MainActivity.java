package com.example.library;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.library.manager.bookDaoManager;
import com.example.library.model.bookmodel;
import com.example.library.utils.Datautils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText nameEdt , authorEdt , pressEdt,priceEdt,pageEdt,scoreEdt,ISBNEdt,DateEdt
            ,contentEdt,linkEdt;
    private TextView insert,query_all,query,update;

    private bookDaoManager mDBManager;
    private String namestr;
    private String authorstr;
    private String pressstr;
    private String pricestr;
    private String scorestr;
    private String datestr;
    private String ISBNstr;
    private String pagestr;
    private String contentstr;
    private String linkstr;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();



    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    private void init() {

        mDBManager = new bookDaoManager(this);
        initView();
    }
    public void initView () {
        insert=findViewById(R.id.insert);
        query_all=findViewById(R.id.query_all);
        query=findViewById(R.id.query);
        update=findViewById(R.id.update);
        nameEdt=findViewById(R.id.name_edt);
        authorEdt= findViewById(R.id.author_edt);
        pressEdt=findViewById(R.id.press_edt);
        priceEdt=findViewById(R.id.price_edt);
        pageEdt=findViewById(R.id.page_edt);
        scoreEdt=findViewById(R.id.score_edt);
        ISBNEdt=findViewById(R.id.ISBN_edt);
        DateEdt=findViewById(R.id.date_edt);
        contentEdt=findViewById(R.id.content_edt);
        linkEdt=findViewById(R.id.link_edt);
}




    @Override
    public void onClick(View view) {

        namestr = nameEdt.getText().toString();
        authorstr = authorEdt.getText().toString();
        pressstr = pressEdt.getText().toString();
        pricestr= priceEdt.getText().toString();
        scorestr = scoreEdt.getText().toString();
        datestr = DateEdt.getText().toString();
        ISBNstr = ISBNEdt.getText().toString();
        pagestr = pageEdt.getText().toString();
        contentstr = contentEdt.getText().toString();
        linkstr = linkEdt.getText().toString();

        switch (view.getId())
        {
            case R.id.insert_all:
                mDBManager.insertallbooks();
                Toast.makeText(this,"数据库加载成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.insert:
                mDBManager.insert(namestr,authorstr,pressstr,pagestr,pricestr,scorestr,
                        datestr,ISBNstr,linkstr,contentstr);
                Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.query_all:
                intent=new Intent();
                intent.setClass(MainActivity.this,queryactivity.class);
                startActivity(intent);
                Toast.makeText(this,"查询所有成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.query:
                if(namestr.equals(""))
                {
                    Toast.makeText(this,"查询失败，名字不能为空",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    List<bookmodel> model=mDBManager.queryByName(namestr);
                    if(model.size()!=0)
                    {
                        authorEdt.setText(model.get(0).getAuthor());
                        pressEdt.setText(model.get(0).getPress());
                        priceEdt.setText(model.get(0).getPrice());
                        ISBNEdt.setText(model.get(0).getISBN());
                        DateEdt.setText(model.get(0).getDate());
                        scoreEdt.setText(model.get(0).getScore());
                        pageEdt.setText(model.get(0).getPage());
                        linkEdt.setText(model.get(0).getLink());

                        Toast.makeText(this,"查询成功",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(this,"没有该图书",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.update:
                if(namestr.equals(""))
                {
                    Toast.makeText(this,"修改失败，名字不能为空",Toast.LENGTH_SHORT).show();
                }
                else{
                    mDBManager.saveData(namestr,authorstr,pressstr,pagestr,pricestr,scorestr,
                            datestr,ISBNstr,linkstr,contentstr);
                    Toast.makeText(this,"修改成功",Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                break;
        }
    }


}