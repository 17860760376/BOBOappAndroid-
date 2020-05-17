package Widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appdemo.R;


public class CustomDialog extends Dialog {
    public CustomDialog(@NonNull Context context) {
        super(context);
    }

    public CustomDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected CustomDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
    private TextView tv_title,tv_message,tv_confirm;
    private String title,message,confirm;
    private  IOnconfirmlistener mIOnconfirmlistener;
    public CustomDialog setTitle(String title) {
        this.title = title;
        return  this;
    }

    public CustomDialog setMessage(String message) {
        this.message = message;
        return this;
    }

    public CustomDialog setConfirm(String confirm, IOnconfirmlistener iOnconfirmlistener) {
        this.confirm = confirm;
        this.mIOnconfirmlistener=iOnconfirmlistener;
        return this;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_dialog);
        WindowManager windowManager = getWindow().getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size= new Point();
        display.getSize(size);
        p.width = (int)(size.x*0.8);
        getWindow().setAttributes(p);
        tv_title=findViewById(R.id.tv_title);
        tv_message=findViewById(R.id.tv_message);
        tv_confirm=findViewById(R.id.tv_queding);
        tv_title.setText(title);
        tv_message.setText(message);
        tv_confirm.setText(confirm);
        tv_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mIOnconfirmlistener.OnConfirm(this);
                    dismiss();
            }
        });
    }


    public interface IOnconfirmlistener {
        void OnConfirm(View.OnClickListener dialog);
    }
}
