package com.ljm.usecamera;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;


public class MyActivity extends Activity implements View.OnClickListener{

    private ImageView img_show;

    //定义一个保存图片的File变量
    private File currentImageFile = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        initView();

        TextView layout = (TextView) findViewById(R.id.textView);

        layout.setOnClickListener(this);
        img_show.setOnClickListener(this);
    }

    private void initView(){
        img_show = (ImageView) findViewById(R.id.img_show);
    }

    private void popToCamera(){
        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(it,Activity.DEFAULT_KEYS_DIALER);
    }

    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.img_show){
            Log.e("tttttttttttttt","dianjile，dianjiledianjiledianjile");
            img_show.setImageURI(Uri.fromFile(currentImageFile));

            return;
        }
        File dir = new File(Environment.getExternalStorageDirectory(),"/LJM");

        if(!dir.exists()){

            Boolean res = dir.mkdir();
            Log.e("hhhhhh", String.valueOf(dir));
            Log.e("rrrrrr", String.valueOf(res));
        }
        currentImageFile = new File(dir,System.currentTimeMillis() + ".jpg");
        if(!currentImageFile.exists()){
            try {
                currentImageFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        it.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(currentImageFile));
        startActivityForResult(it, Activity.DEFAULT_KEYS_DIALER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            Log.e("taggg", String.valueOf(Uri.fromFile(currentImageFile)));

        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
