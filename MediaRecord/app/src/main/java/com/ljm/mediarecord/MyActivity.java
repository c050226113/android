package com.ljm.mediarecord;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;


public class MyActivity extends Activity {
    private Button btn_control;
    private boolean isStart = false;
    private MediaRecorder mr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        btn_control = (Button) findViewById(R.id.btn_control);
        btn_control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isStart) {
                    startRecord();
                    btn_control.setText("停止录制");
                    isStart = true;
                } else {
                    stopRecord();
                    btn_control.setText("开始录制");
                    isStart = false;
                }
            }
        });
    }

    //开始录制
    private void startRecord(){
        if(mr == null){
            File dir = new File(Environment.getExternalStorageDirectory(),"sounds");
            if(!dir.exists()){
                dir.mkdirs();
            }
            File soundFile = new File(dir,System.currentTimeMillis()+".amr");
            if(!soundFile.exists()){
                try {
                    soundFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            mr = new MediaRecorder();
            mr.setAudioSource(MediaRecorder.AudioSource.MIC);  //音频输入源
            mr.setOutputFormat(MediaRecorder.OutputFormat.AMR_WB);   //设置输出格式
            mr.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_WB);   //设置编码格式
            mr.setOutputFile(soundFile.getAbsolutePath());
            try {
                mr.prepare();
                mr.start();  //开始录制
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //停止录制，资源释放
    private void stopRecord(){
        if(mr != null){
            mr.stop();
            mr.release();
            mr = null;
        }
    }
}
