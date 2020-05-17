package View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.example.appdemo.R;

import Save.AutoLogin;
import Save.AutoLoginimp;
import View.HomePage.Maininterface_activity;

public class StartViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start_view);
        Thread thread = new Thread(){
          public void run(){
              try {
                  sleep(2000);
                  //TODO 判断跳转到登录界面还是跳转到首页
                  AutoLogin autoLogin = new AutoLoginimp();
                  if(autoLogin.JudgeAutoLogin(StartViewActivity.this)) {
                      Intent intent = new Intent(StartViewActivity.this, Maininterface_activity.class);
                      startActivity(intent);
                      finish();
                  }else{
                      Intent intent = new Intent(StartViewActivity.this,LoginView_activity.class);
                      startActivity(intent);
                      finish();
                  }

              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        };
        thread.start();
    }
}
