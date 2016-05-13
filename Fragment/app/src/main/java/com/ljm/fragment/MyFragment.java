package com.ljm.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 20140624 on 2015/12/9.
 */
public class MyFragment extends Fragment {

    public Button btn;
    public View _view;
    private String aaa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //把layout布局文件转换成View、对象

        _view = inflater.inflate(R.layout.fragment, container, false);

        TextView text = (TextView) _view.findViewById(R.id.text);
        text.setText("静态加载Fragment");

        btn = (Button) _view.findViewById(R.id.button444);



        return _view;
    }

    public Boolean setBtnName(String name){
        this.btn.setText(name);

        return true;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

    public String getAaa() {
        return aaa;
    }
}
