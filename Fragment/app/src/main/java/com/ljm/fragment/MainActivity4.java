package com.ljm.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 20140624 on 2015/12/9.
 */
public class MainActivity4 extends Activity implements MyFragment5.MyListener {

    private EditText editext;
    private Button send;
    private Button btn;
    private MyFragment frag;
    private  FragmentTransaction transation;
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main4);

        editext = (EditText) findViewById(R.id.editText);
        send = (Button) findViewById(R.id.send);


        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                String text = editext.getText().toString();
//                MyFragment5 fragment5 = new MyFragment5();
//                Bundle bundle = new Bundle();
//                bundle.putString("name", text);
//                fragment5.setArguments(bundle);
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction beginTransaction = fragmentManager
//                        .beginTransaction();
//                beginTransaction.add(R.id.layout, fragment5, "fragment5");
//                beginTransaction.commit();
//                Toast.makeText(MainActivity4.this, "向Fragment发送数据" + text,
//                        Toast.LENGTH_SHORT).show();

                frag.setBtnName("change");
//                if(flag<1){
//                    flag++;
//
//                    transation.hide(frag).commit();
//
//                }else{
//
//                    transation.show(frag).commit();
//
//                }

            }
        });
        transation = getFragmentManager().beginTransaction();
        frag = new MyFragment();
        transation.add(R.id.fragment444,frag);
        transation.show(frag).commit();


        frag.setAaa("fragment静态传值");



//
//
//        frag.btn.setText("change");
//
//
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String value = frag.getAaa();
//
//                Toast.makeText(MainActivity4.this,value+"", Toast.LENGTH_SHORT ).show();
//
//            }
//        });


    }

    @Override
    public void thank(String code) {
        // TODO Auto-generated method stub
        Toast.makeText(MainActivity4.this, "已成功接收到" + code + "，客气了！",
                Toast.LENGTH_SHORT).show();
    }

}