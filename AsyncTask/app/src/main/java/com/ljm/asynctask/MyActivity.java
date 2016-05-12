package com.ljm.asynctask;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MyActivity extends Activity {


    private Context _context;
    private TextView txttitle;
    private ProgressBar pgbar;
    private Button btnupdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        _context = MyActivity.this;

        txttitle = (TextView)findViewById(R.id.txttitle);
        pgbar = (ProgressBar)findViewById(R.id.pgbar);
        btnupdate = (Button)findViewById(R.id.btnupdate);
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTask myTask = new MyAsyncTask(txttitle,pgbar);
                myTask.execute(1000);
            }
        });
    }

    public class DelayOperator {
        //延时操作,用来模拟下载
        public void delay()
        {
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();;
            }
        }
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    public class MyAsyncTask extends AsyncTask<Integer,Integer,String>
    {
        private TextView txt;
        private ProgressBar pgbar;

        public MyAsyncTask(TextView txt,ProgressBar pgbar)
        {
            super();
            this.txt = txt;
            this.pgbar = pgbar;
        }


        //该方法不运行在UI线程中,主要用于异步操作,通过调用publishProgress()方法
        //触发onProgressUpdate对UI进行操作
        @Override
        protected String doInBackground(Integer... params) {
            DelayOperator dop = new DelayOperator();
            int i = 0;
            for (i = 10;i <= 100;i+=10)
            {
                dop.delay();
                publishProgress(i);
            }
            return  i + params[0].intValue() + "";
        }

        //该方法运行在UI线程中,可对UI控件进行设置
        @Override
        protected void onPreExecute() {
            txt.setText("开始执行异步线程~");
        }


        //在doBackground方法中,每次调用publishProgress方法都会触发该方法
        //运行在UI线程中,可对UI控件进行操作


        @Override
        protected void onProgressUpdate(Integer... values) {
            int value = values[0];
            pgbar.setProgress(value);
        }
    }
}
