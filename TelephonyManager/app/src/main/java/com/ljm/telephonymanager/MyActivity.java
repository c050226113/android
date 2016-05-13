package com.ljm.telephonymanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MyActivity extends Activity {
    private Context _context;
    private TelephonyManager _telephoneManager;

    private TextView tv_phone1;
    private TextView tv_phone2;
    private TextView tv_phone3;
    private TextView tv_phone4;
    private TextView tv_phone5;
    private TextView tv_phone6;
    private TextView tv_phone7;
    private TextView tv_phone8;
    private TextView tv_phone9;
    private String[] phoneType = {"未知","2G","3G","4G"};
    private String[] simState = {"状态未知","无SIM卡","被PIN加锁","被PUK加锁",
            "被NetWork PIN加锁","已准备好"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        initData();

        initView();

    }

    private void initData(){
        _context = MyActivity.this;
        _telephoneManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
    }

    private void initView(){
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri=Uri.parse("tel:"+"18566650234");
                Intent intent=new Intent(Intent.ACTION_DIAL,uri);
                startActivity(intent);
            }
        });

        tv_phone1 = (TextView) findViewById(R.id.tv_phone1);
        tv_phone2 = (TextView) findViewById(R.id.tv_phone2);
        tv_phone3 = (TextView) findViewById(R.id.tv_phone3);
        tv_phone4 = (TextView) findViewById(R.id.tv_phone4);
        tv_phone5 = (TextView) findViewById(R.id.tv_phone5);
        tv_phone6 = (TextView) findViewById(R.id.tv_phone6);
        tv_phone7 = (TextView) findViewById(R.id.tv_phone7);
        tv_phone8 = (TextView) findViewById(R.id.tv_phone8);
        tv_phone9 = (TextView) findViewById(R.id.tv_phone9);

        tv_phone1.setText("设备编号：" + _telephoneManager.getDeviceId());
        tv_phone1.setText("设备编号：" + _telephoneManager.getDeviceId());
        tv_phone2.setText("软件版本：" + (_telephoneManager.getDeviceSoftwareVersion()!= null?
                _telephoneManager.getDeviceSoftwareVersion():"未知"));
        tv_phone3.setText("运营商代号：" + _telephoneManager.getNetworkOperator());
        tv_phone4.setText("运营商名称：" + _telephoneManager.getNetworkOperatorName());
        tv_phone5.setText("网络类型：" + phoneType[_telephoneManager.getPhoneType()]);
        tv_phone6.setText("设备当前位置：" + (_telephoneManager.getCellLocation() != null ? _telephoneManager
                .getCellLocation().toString() : "未知位置"));
        tv_phone7.setText("SIM卡的国别：" + _telephoneManager.getSimCountryIso());
        tv_phone8.setText("SIM卡序列号：" + _telephoneManager.getSimSerialNumber());
        tv_phone9.setText("SIM卡状态：" + simState[_telephoneManager.getSimState()]);

        _telephoneManager.getNetworkType();
        //判断
        /*
        Network type is unknown
        public static final int NETWORK_TYPE_UNKNOWN = 0;
       Current network is GPRS
        public static final int NETWORK_TYPE_GPRS = 1;
        Current network is EDGE
        public static final int NETWORK_TYPE_EDGE = 2;
        Current network is UMTS
        public static final int NETWORK_TYPE_UMTS = 3;
         Current network is CDMA: Either IS95A or IS95B
        public static final int NETWORK_TYPE_CDMA = 4;
         Current network is EVDO revision 0
        public static final int NETWORK_TYPE_EVDO_0 = 5;
         Current network is EVDO revision A
        public static final int NETWORK_TYPE_EVDO_A = 6;
         Current network is 1xRTT
        public static final int NETWORK_TYPE_1xRTT = 7;
         Current network is HSDPA
        public static final int NETWORK_TYPE_HSDPA = 8;
         Current network is HSUPA
        public static final int NETWORK_TYPE_HSUPA = 9;
         Current network is HSPA
        public static final int NETWORK_TYPE_HSPA = 10;
         Current network is iDen
        public static final int NETWORK_TYPE_IDEN = 11;
         Current network is EVDO revision B
        public static final int NETWORK_TYPE_EVDO_B = 12;
         Current network is LTE
        public static final int NETWORK_TYPE_LTE = 13;
         Current network is eHRPD
        public static final int NETWORK_TYPE_EHRPD = 14;
         Current network is HSPA+
        public static final int NETWORK_TYPE_HSPAP = 15;
         Current network is GSM {@hide}
        public static final int NETWORK_TYPE_GSM = 16;
         Current network is TD_SCDMA {@hide}
        public static final int NETWORK_TYPE_TD_SCDMA = 17;
         Current network is IWLAN {@hide}
        public static final int NETWORK_TYPE_IWLAN = 18;
        *
        * */


        /*
        * 3)获取手机的信号强度
        * */

         /*
        * 4)监听手机的所有来电
        * */

 /*
        * 5)黑名单来电自动挂断
        * */
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
