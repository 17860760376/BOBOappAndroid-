package Widget;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appdemo.R;
import View.FindbackpswActivity;
import View.PhoneLoginActivity;

public class Dialoglostpsw extends Dialog {

    Context mContext;
    public Dialoglostpsw(@NonNull Context context) {
        super(context);
    }

    public Dialoglostpsw(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected Dialoglostpsw(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    TextView tv_phonelogin,tv_findpsw;
    public void setContext(Context context) {
        mContext = context;
    }
    public Dialoglostpsw setPhonelogin(String phonelogin) {
        this.phonelogin = phonelogin;
        return this;
    }

    public Dialoglostpsw setFindpsw(String findpsw) {
        this.findpsw = findpsw;
        return this;
    }

    String phonelogin,findpsw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lostpsw_dialog);

        WindowManager windowManager = getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size= new Point();
        display.getSize(size);
        p.width = size.x;
        getWindow().setAttributes(p);


        tv_phonelogin=findViewById(R.id.tv_phonelogin);
        tv_findpsw=findViewById(R.id.tv_findpsw);
        tv_phonelogin.setText(phonelogin);
        tv_findpsw.setText(findpsw);
        tv_phonelogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,PhoneLoginActivity.class);
                mContext.startActivity(intent);
            }
        });
        tv_findpsw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, FindbackpswActivity.class);
                mContext.startActivity(intent);
            }
        });
    }

}
