package View;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.appdemo.R;

import Save.AutoLogin;
import Save.AutoLoginimp;
import View.HomePage.Maininterface_activity;
import Widget.CustomDialog;
import Widget.Dialoglostpsw;
import beans.User;
import opWithBackground.ConnectByUser;
import opWithBackground.TheUserCnBackground;
import utility.CommonMulClick;

public class LoginView_activity extends AppCompatActivity {

    final String USERNAME = "";
    final String PASSWORD = null;


    EditText et_username,et_password;
    ImageView bt_loginbutton;
    ImageView iv_remove1,iv_remove2;
    TextView tv_register,tv_findbackpassword;
    Handler mHandler = new Handler();
    CheckBox cb_pswmingan;
    public static LoginView_activity instance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginview);
        instance = this;

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        iv_remove1=findViewById(R.id.iv_remove1);
        iv_remove2=findViewById(R.id.iv_remove2);
        cb_pswmingan=findViewById(R.id.cb_pswmingan);
        bt_loginbutton = findViewById(R.id.bt_loginbutton);
        tv_register = findViewById(R.id.register);
        tv_findbackpassword = findViewById(R.id.findback_password);
        tv_findbackpassword.getPaint().setFakeBoldText(true);
        tv_register.getPaint().setFakeBoldText(true);
        Glide.with(this).load("https://pic4.zhimg.com/80/v2-fad1208c08abc2f6bbaebc07cd7e8830_720w.jpg").into(bt_loginbutton);
        //找回密码的点击事件
        tv_findbackpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialoglostpsw dialoglostpsw = new Dialoglostpsw(LoginView_activity.this);
                Window window = dialoglostpsw.getWindow();
                window.setGravity(Gravity.BOTTOM);
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams layoutParams = window.getAttributes();
                layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                window.setAttributes(layoutParams);
                window.getDecorView().setBackgroundColor(Color.WHITE);
                dialoglostpsw.setContext(LoginView_activity.this);
                dialoglostpsw.setPhonelogin("手机号验证登陆")
                        .setFindpsw("找回密码").show();
            }
        });



        //登陆按钮的点击事件
        bt_loginbutton.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if(CommonMulClick.isFastDoubleClick())return;//消除多次点击的bug
                else {
                    //TODO 将用户名和密码传递给后台进行判断，并返回一个结果，根据结果进行不同的决策。
                    String result = "你好";
                    User user = new User();
                    user.setUsername(USERNAME);
                    user.setPassword(PASSWORD);

                    TheUserCnBackground theUserCnBackground = new ConnectByUser();
                    //TODO 降低了耦合
//                    result = theUserCnBackground.logByUserAndPaw(user);



                    if(result.length()!=20){
                        //TODO 这里进行自动登录的功能
                        AutoLogin autoLogin = new AutoLoginimp();
                        //TODO 运行的时候加上下面这行代码
//                        autoLogin.SaveUser(LoginView_activity.this,USERNAME);
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                Intent intent = new Intent(LoginView_activity.this, Maininterface_activity.class);
                                startActivity(intent);
                            }
                        });
                    }
                    else {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                CustomDialog customDialog = new CustomDialog(LoginView_activity.this);
                                customDialog.setTitle("登陆失败")
                                        .setMessage("账号或密码错误，请重新输入。").
                                        setConfirm("确定", new CustomDialog.IOnconfirmlistener() {
                                            @Override
                                            public void OnConfirm(View.OnClickListener dialog) {

                                            }
                                        }).show();
                                customDialog.setCanceledOnTouchOutside(false);
                            }
                        });
                    }
                }
            }
        });






        //注册用户的点击事件
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginView_activity.this,Registerview_activity.class);
                startActivity(intent);
            }
        });




        //用户名输入框的监听事件
        et_username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    et_username.setHint("");
                    iv_remove1.setVisibility(View.VISIBLE);
                    iv_remove1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            et_username.setText("");
                        }
                    });
                }
                else {
                    et_username.setHint("请输入手机号");
                    iv_remove1.setVisibility(View.INVISIBLE);
                }
            }
        });


        //同上，密码输入框的监听事件
        et_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    et_password.setHint("");
                    iv_remove2.setVisibility(View.VISIBLE);
                    cb_pswmingan.setVisibility(View.VISIBLE);
                    iv_remove2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            et_password.setText("");
                        }
                    });
                    cb_pswmingan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(isChecked) et_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            else et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        }
                    });
                }
                else {
                    cb_pswmingan.setVisibility(View.INVISIBLE);
                    et_password.setHint("请输入登陆密码");
                    iv_remove2.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}




