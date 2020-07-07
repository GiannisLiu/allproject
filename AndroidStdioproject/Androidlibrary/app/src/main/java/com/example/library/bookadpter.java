package com.example.library;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.library.model.bookmodel;

import java.util.List;

public class bookadpter extends BaseAdapter {
    private List<bookmodel> dataSource;
    private Context mContext;

    public bookadpter(Context context,List<bookmodel> dataSource) {
        this.mContext = context;
        this.dataSource = dataSource;
    }



    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return dataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final bookmodel model = dataSource.get(i);

        Viewhandle viewhandle=new Viewhandle();
        if(view==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.books_item,null);
            viewhandle.mappauthoetextview=(TextView)view.findViewById(R.id.tv_author);
            viewhandle.mappiconimageview=(ImageView) view.findViewById(R.id.iv_icon);
            viewhandle.mappprice=(TextView)view.findViewById(R.id.tv_price);
            viewhandle.mappnametextview=(TextView)view.findViewById(R.id.tv_name);
            viewhandle.mappscroce=(TextView)view.findViewById(R.id.tv_scroce);
            view.setTag(viewhandle);
        }else
        {
            viewhandle= (Viewhandle) view.getTag();

        }
        viewhandle.mappnametextview.setText(dataSource.get(i).getName());
        viewhandle.mappscroce.setText(dataSource.get(i).getScore());
        viewhandle.mappprice.setText(dataSource.get(i).getPrice());
        viewhandle.mappauthoetextview.setText(dataSource.get(i).getAuthor());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(mContext,bookdetailactivity.class);
                intent.putExtra("bookmodel", model);
                mContext.startActivity(intent);
            }
        });


        return view;
    }
    class Viewhandle
    {
        public ImageView mappiconimageview;
        public TextView mappnametextview;
        public TextView mappauthoetextview;
        public TextView mappprice;
        public TextView mappscroce;
    }
}
