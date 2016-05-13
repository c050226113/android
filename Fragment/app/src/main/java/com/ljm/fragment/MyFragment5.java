package com.ljm.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 20140624 on 2015/12/9.
 */
public class MyFragment5 extends Fragment {

    private Context _context;
    private String code="Thank you,Activity!";

    public MyListener listener;
    public interface MyListener
    {
        public void thank(String code);
    }

    @Override
    public void onAttach(Activity activity) {
        // TODO Auto-generated method stub
        listener=(MyListener) activity;
        _context = activity;
        super.onAttach(activity);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.fragment2, container, false);
        TextView tv = (TextView) view.findViewById(R.id.text);
        String text=getArguments().get("name")+"";
        tv.setText(text);
        Toast.makeText(_context, "已成功接收到" + text, Toast.LENGTH_SHORT).show();
        Toast.makeText(_context, "向Activity发送"+code, Toast.LENGTH_SHORT).show();
        listener.thank(code);
        return view;
    }
}
