package Save;

import android.content.Context;
import android.content.SharedPreferences;

public class AutoLoginimp implements AutoLogin{

        @Override
        public void SaveUser(Context context, String username) {
                SharedPreferences sp = context.getSharedPreferences("AutoLogin",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("username",username);
                editor.commit();
        }

        @Override
        public boolean JudgeAutoLogin(Context context) {
                SharedPreferences sp = context.getSharedPreferences("AutoLogin",Context.MODE_PRIVATE);
                if(sp.contains("username"))return true;
                return false;
        }

        @Override
        public void DestroyAutoLogin(Context context) {
                SharedPreferences sp = context.getSharedPreferences("AutoLogin",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.remove("username");
                editor.commit();
        }
}
