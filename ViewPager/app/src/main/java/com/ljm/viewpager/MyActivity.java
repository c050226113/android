package com.ljm.viewpager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.ljm.viewpager.VIews.FourActivity;
import com.ljm.viewpager.VIews.OneActivity;
import com.ljm.viewpager.VIews.ThreeActivity;
import com.ljm.viewpager.VIews.TwoActivity;


public class MyActivity extends Activity implements View.OnClickListener{


    private Context _context;
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private Button btn_four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _context = MyActivity.this;
        initViews();
    }

    private void initViews() {
        btn_one = (Button) findViewById(R.id.btn_one);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_three = (Button) findViewById(R.id.btn_three);
        btn_four = (Button) findViewById(R.id.btn_four);
        btn_one.setOnClickListener(this);
        btn_two.setOnClickListener(this);
        btn_three.setOnClickListener(this);
        btn_four.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                startActivity(new Intent(_context, OneActivity.class));
                break;
            case R.id.btn_two:
                startActivity(new Intent(_context, TwoActivity.class));
                break;
            case R.id.btn_three:
                startActivity(new Intent(_context, ThreeActivity.class));
                break;
            case R.id.btn_four:
                startActivity(new Intent(_context, FourActivity.class));
                break;
        }
    }

}
