package com.ljm.viewpager.VIews;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.ljm.viewpager.PageAdapter.MyPagerAdapter2;
import com.ljm.viewpager.R;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/10 0010.
 */
public class ThreeActivity extends Activity{

    private ViewPager vpager_three;
    private ArrayList<View> aList;
    private ArrayList<String> sList;
    private MyPagerAdapter2 mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        vpager_three = (ViewPager) findViewById(R.id.vpager_three);
        aList = new ArrayList<View>();
        LayoutInflater li = getLayoutInflater();
        aList.add(li.inflate(R.layout.view_one, null, false));
        aList.add(li.inflate(R.layout.view_two, null, false));
        aList.add(li.inflate(R.layout.view_three, null, false));
        sList = new ArrayList<String>();
        sList.add("橘黄");
        sList.add("淡黄");
        sList.add("浅棕");
        mAdapter = new MyPagerAdapter2(aList, sList);
        vpager_three.setAdapter(mAdapter);
    }
}
