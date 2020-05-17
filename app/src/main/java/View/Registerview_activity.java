package View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appdemo.R;

import View.HomePage.Maininterface_activity;
import Widget.CountDownTimerUtils;
import Widget.CustomDialog;
import Widget.EditWatcher;
import beans.User;
import opWithBackground.ConnectByUser;
import opWithBackground.TheUserCnBackground;
import utility.JudgePhone;

public class Registerview_activity extends AppCompatActivity {

    EditText tv_phone,tv_note,tv_password;
    Button bt_resgister;
    TextView tv_sendnote;
    String phone = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerview_activity);
        tv_phone=findViewById(R.id.et_phone);
        tv_note=findViewById(R.id.et_note);
        tv_password=findViewById(R.id.et_password);
        bt_resgister=findViewById(R.id.bt_button);
        tv_sendnote=findViewById(R.id.tv_sendnote);
        //TODO 发送验证码的点击监听事件
        tv_sendnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phone = tv_phone.getText().toString();
                if(JudgePhone.isPhoneNumber(phone)){
                    // TODO 这里设置一下
                    Toast.makeText(Registerview_activity.this,"验证码已发送，请注意查收",Toast.LENGTH_SHORT).show();
                    CountDownTimerUtils mCountDownTimerUtils = new CountDownTimerUtils(tv_sendnote, 60000, 1000); //倒计时1分钟
                    mCountDownTimerUtils.start();

                }
                else {
                    CustomDialog customDialog = new CustomDialog(Registerview_activity.this);
                    customDialog.setTitle("获取验证码失败！")
                            .setMessage("手机号错误，请重新输入。").
                            setConfirm("确定", new CustomDialog.IOnconfirmlistener() {
                                @Override
                                public void OnConfirm(View.OnClickListener dialog) {

                                }
                            }).show();

                }
            }
        });
        //TODO 登陆按钮的点击事件
        bt_resgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = tv_phone.getText().toString();
                String note = tv_note.getText().toString();
                String password = tv_password.getText().toString();
                if(!JudgePhone.isPhoneNumber(phone)){
                    CustomDialog customDialog = new CustomDialog(Registerview_activity.this);
                    customDialog.setTitle("注册失败！")
                            .setMessage("手机号错误，请重新输入。").
                            setConfirm("确定", new CustomDialog.IOnconfirmlistener() {
                                @Override
                                public void OnConfirm(View.OnClickListener dialog) {

                                }
                            }).show();
                }
                else if(password.length()<6){
                    CustomDialog customDialog = new CustomDialog(Registerview_activity.this);
                    customDialog.setTitle("注册失败！")
                            .setMessage("密码长度太短，请重新输入。").
                            setConfirm("确定", new CustomDialog.IOnconfirmlistener() {
                                @Override
                                public void OnConfirm(View.OnClickListener dialog) {

                                }
                            }).show();
                }
                else {
                    User user = new User();
                    user.setUsername(phone);
                    user.setNote(note);
                    user.setPassword(password);
                    TheUserCnBackground theUserCnBackground = new ConnectByUser();
                    String result = theUserCnBackground.resgisterByUserAndPawAndNote(user);
                    //TODO 这里也是一个与后台服务器进行交互的地方
                    if (result == "true"){
                        Intent intent = new Intent(Registerview_activity.this, Maininterface_activity.class);
                        startActivity(intent);
                    }
                    else {
                        //TODO 这里吐个丝就行，有2种形式，1是手机号已经注册，2是短信验证码错误
                    }
                }
            }
        });
        //TODO 实现了当editview中有内容的时候tv和bt才能够点击的功能
        EditWatcher editWatcher = new EditWatcher();
        editWatcher.addEditList(tv_phone).addEditList(tv_note)
                .addEditList(tv_password).setTextView(tv_sendnote).setButton(bt_resgister)
                .setContent(Registerview_activity.this).build();


    }

}