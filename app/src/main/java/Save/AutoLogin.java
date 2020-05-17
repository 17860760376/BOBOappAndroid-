package Save;

import android.content.Context;
//TODO 自动登录功能，包括的操作：实现自动登录，判断自动登录，取消自动登录
public interface AutoLogin {
    void SaveUser(Context context,String username);
    boolean JudgeAutoLogin(Context context);
    void DestroyAutoLogin(Context context);
}
