package com.ljm.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RadioGroup;


public class MyActivity extends Activity {
    private RadioGroup radioGroup;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        init();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.first:
                        Intent intent=new Intent(MyActivity.this,MainActivity2.class);
                        startActivity(intent);
                        break;
                    case R.id.second:

                        if(linearLayout.getChildCount() == 0)
                        {
                            MyFragment2 fragment2 = new MyFragment2();
                            FragmentManager fragmentManager = getFragmentManager();
                            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                            beginTransaction.add(R.id.frame, fragment2);
                            beginTransaction.addToBackStack(null);
                            beginTransaction.commit();
                        }

                        break;
                    case R.id.thrid:
                        Intent intent3=new Intent(MyActivity.this,MainActivity3.class);
                        startActivity(intent3);

                        break;
                    case R.id.fourth:
                        Intent intent4=new Intent(MyActivity.this,MainActivity4.class);
                        startActivity(intent4);
                        break;
                }
            }
        });
    }

    private void init() {
        radioGroup = (RadioGroup) findViewById(R.id.group);

        linearLayout = (LinearLayout) findViewById(R.id.frame);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
