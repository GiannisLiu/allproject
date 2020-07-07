package com.example.library;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.library.manager.bookDaoManager;
import com.example.library.model.bookmodel;

public class bookdetailactivity extends AppCompatActivity {
    private bookDaoManager mDbManager;
    private EditText mEtInfo;
    private bookmodel mbooksModel;
    private EditText nameEdt;
    private EditText authorEdt;
    private EditText pressEdt;
    private EditText priceEdt;
    private EditText pageEdt;
    private EditText scoreEdt;
    private EditText isbnEdt;
    private EditText dateEdt;
    private EditText linkEdt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);
        mDbManager = new bookDaoManager(this);
        mbooksModel = getIntent().getParcelableExtra("bookmodel");
        initView();



    }
    public void initView () {
        mEtInfo = findViewById(R.id.et_info);
        nameEdt = findViewById(R.id.detail_name);
        authorEdt = findViewById(R.id.detai_author);
        pressEdt = findViewById(R.id.detai_press);
        priceEdt = findViewById(R.id.detai_price);
        pageEdt = findViewById(R.id.detail_page);
        scoreEdt = findViewById(R.id.detail_score);
        isbnEdt = findViewById(R.id.detai_ISBN);
        dateEdt = findViewById(R.id.detail_date);
        linkEdt = findViewById(R.id.detail_link);
        mEtInfo.setText(mbooksModel.getContent_description());
        nameEdt.setText(mbooksModel.getName());
        authorEdt.setText(mbooksModel.getAuthor());
        pressEdt.setText(mbooksModel.getPress());
        priceEdt.setText(mbooksModel.getPrice());
        pageEdt.setText(mbooksModel.getPage());
        scoreEdt.setText(mbooksModel.getScore());
        isbnEdt.setText(mbooksModel.getISBN());
        dateEdt.setText(mbooksModel.getDate());
        linkEdt.setText(mbooksModel.getLink());


    }

    /**
     * 保存编辑点击事件
     * @param v
     */
    public void onEditClick(View v) {
        String info = mEtInfo.getText().toString();
        String name = nameEdt.getText().toString();
        String auehor = authorEdt.getText().toString();
        String isbn = isbnEdt.getText().toString();
        String page = pageEdt.getText().toString();
        String price = priceEdt.getText().toString();
        String press = pressEdt.getText().toString();
        String score = scoreEdt.getText().toString();
        String link = linkEdt.getText().toString();
        String date = dateEdt.getText().toString();


        mbooksModel.setContent_description(info);
        mbooksModel.setISBN(isbn);
        mbooksModel.setScore(score);
        mbooksModel.setDate(date);
        mbooksModel.setPrice(price);
        mbooksModel.setPress(press);
        mbooksModel.setAuthor(auehor);
        mbooksModel.setName(name);
        mbooksModel.setPage(page);
        mbooksModel.setLink(link);

        mDbManager.updatebookInfo(mbooksModel);
        onBackPressed();
    }

    /**
     * 删除商品
     * @param v
     */
    public void onDelClick(View v) {
        String info = mEtInfo.getText().toString();
        mbooksModel.setContent_description(info);
        mDbManager.deletebookInfo(mbooksModel);
        onBackPressed();
    }
}
