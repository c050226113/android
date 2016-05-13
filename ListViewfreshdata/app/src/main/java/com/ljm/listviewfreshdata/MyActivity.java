package com.ljm.listviewfreshdata;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ljm.listviewfreshdata.Model.Data;
import com.ljm.listviewfreshdata.Model.DataAdapter;

import java.util.LinkedList;
import java.util.List;


public class MyActivity extends Activity implements View.OnClickListener {

    private ListView list_one;
    private DataAdapter mAdapter = null;
    private List<Data> mData = null;
    private Context mContext = null;
    private TextView txt_empty;

    private Button btn_add;

    private Button btn_add2;

    private int flag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mContext = MyActivity.this;
        bindViews();
        mData = new LinkedList<Data>();
        mAdapter = new DataAdapter((LinkedList<Data>) mData,mContext);
        list_one.setAdapter(mAdapter);
    }

    private void bindViews(){
        list_one = (ListView) findViewById(R.id.list_one);

//        txt_empty = (TextView) findViewById(R.id.txt_empty);
//        txt_empty.setText("暂无数据~");
//        list_one.setEmptyView(txt_empty);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);

        btn_add2 = (Button) findViewById(R.id.btn_add2);
        btn_add2.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                mAdapter.add(new Data(R.drawable.ic_launcher,"给猪哥跪了~~~ x " + flag++));
                break;
            case R.id.btn_add2:
                //position从0开始算的
                mAdapter.add(4,new Data(R.drawable.ic_launcher,"给猪哥跪了~~~ x " + flag++));
                break;
        }
    }
}
