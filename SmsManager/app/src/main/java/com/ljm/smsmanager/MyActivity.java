package com.ljm.smsmanager;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;


public class MyActivity extends Activity {
    private Context _context = MyActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        //1）处理返回发送状态的sentIntent
        //处理返回的发送状态
        String SENT_SMS_ACTION = "SENT_SMS_ACTION";
        Intent sentIntent = new Intent(SENT_SMS_ACTION);
        PendingIntent sentPI = PendingIntent.getBroadcast(_context, 0, sentIntent,  0);
        //注册发送信息的广播接收者
        _context.registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context _context, Intent _intent) {
                switch (getResultCode()) {
                    case Activity.RESULT_OK:
                        Toast.makeText(_context, "短信发送成功", Toast.LENGTH_SHORT).show();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:    //普通错误
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:         //无线广播被明确地关闭
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:          //没有提供pdu
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:         //服务当前不可用
                        break;
                }
            }
        }, new IntentFilter(SENT_SMS_ACTION));

        //2）处理返回接收状态的deliverIntent：
//处理返回的接收状态
        String DELIVERED_SMS_ACTION = "DELIVERED_SMS_ACTION";
//创建接收返回的接收状态的Intent
        Intent deliverIntent = new Intent(DELIVERED_SMS_ACTION);
        PendingIntent deliverPI = PendingIntent.getBroadcast(_context, 0,deliverIntent, 0);
        _context.registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context _context, Intent _intent) {
                Toast.makeText(_context,"收信人已经成功接收", Toast.LENGTH_SHORT).show();
            }
        }, new IntentFilter(DELIVERED_SMS_ACTION));
    }


    /*
    * sendSMS 是调用发短信的接口 需要用户同意
    *
    * */

    public void sendSMS(String phoneNumber,String message){
        //获取短信管理器
        android.telephony.SmsManager smsManager = android.telephony.SmsManager.getDefault();
        //拆分短信内容（手机短信长度限制）,貌似长度限制为140个字符,就是
        //只能发送70个汉字,多了要拆分成多条短信发送
        //第四五个参数,如果没有需要监听发送状态与接收状态的话可以写null
        List<String> divideContents = smsManager.divideMessage(message);
        for (String text : divideContents) {
            smsManager.sendTextMessage(phoneNumber, null, text, sentPI, deliverPI);
        }
    }

/*1.调用系统发送短信功能：


* 就是把写好的收信人和内容发送到系统的发送短信的界面，用户验证收件人内容是否真正确再点击发送! 说白了就是调用系统发短信的窗口,
* 这样做有一定的好处:
这样发短信,app安装的时候就可以少写一条发短信的权限，那么诸如360这类安全软件在安装的时候 就不会提醒用户：
"这个APP有短信权限，可能会偷偷滴发短信喔"，而用户对于偷偷发短信的行为是十分 厌恶的，当然有些人不看直接安装，
而有些人可能会觉得会偷偷发短信喔，好恶心的应用，我才不装咧， 又或者直接禁止我们的APP发送短信，
那么当我们APP在发送短信的时候就可能会出现一些异常，或者 应用直接崩溃等！
所以如果你的应用需要发送短信进行验证或者付费这些东西的话,建议使用这种方式!
* */
    public void SendSMSTo(String phoneNumber,String message){
        //判断输入的phoneNumber是否为合法电话号码
        if(PhoneNumberUtils.isGlobalPhoneNumber(phoneNumber)){
            //Uri.parse("smsto") 这里是转换为指定Uri,固定写法
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNumber));
            intent.putExtra("sms_body", message);
            startActivity(intent);
        }
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
