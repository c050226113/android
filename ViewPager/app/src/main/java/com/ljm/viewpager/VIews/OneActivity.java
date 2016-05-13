package com.ljm.viewpager.VIews;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.ljm.viewpager.PageAdapter.MyPageAdapter;
import com.ljm.viewpager.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/10 0010.
 */
public class OneActivity extends Activity {
    private ViewPager vpager_one;
    private ArrayList<View> _viewList;
    private MyPageAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        vpager_one = (ViewPager) findViewById(R.id.vpager_one);

        _viewList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        _viewList.add(li.inflate(R.layout.view_one,null,false));
        _viewList.add(li.inflate(R.layout.view_two,null,false));
        _viewList.add(li.inflate(R.layout.view_three,null,false));
        mAdapter = new MyPageAdapter(_viewList);
        vpager_one.setAdapter(mAdapter);
    }
}
