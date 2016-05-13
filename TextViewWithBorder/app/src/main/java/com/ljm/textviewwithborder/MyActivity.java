package com.ljm.textviewwithborder;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MyActivity extends Activity {


    /*
    * 自行编写一个ShapeDrawable的资源文件！
    *
    * <solid android:color = "xxx"> 这个是设置背景颜色的
<stroke android:width = "xdp" android:color="xxx"> 这个是设置边框的粗细,以及边框颜色的
<padding androidLbottom = "xdp"...> 这个是设置边距的
<corners android:topLeftRadius="10px"...> 这个是设置圆角的
<gradient> 这个是设置渐变色的,可选属性有: startColor:起始颜色 endColor:结束颜色
centerColor:中间颜色 angle:方向角度,等于0时,从左到右,然后逆时针方向转,当angle = 90度时从下往上 type:设置渐变的类型
    *
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
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
