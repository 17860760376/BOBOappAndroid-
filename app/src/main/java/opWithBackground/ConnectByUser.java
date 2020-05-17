package opWithBackground;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.IOException;

import beans.User;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ConnectByUser implements TheUserCnBackground {
    final String URLlog="";
    final String URLresgister="";



    //TODO find操作
    @Override
    public String logByUserAndPaw(User user) {
        String result = null;
        //TODO 这里将user转化成json格式传递给URL，还要将接受到的result由json格式转换回来
        //TODO 完成登录

        return  result;
    }

    //TODO add操作
    @Override
    public String resgisterByUserAndPawAndNote(User user) {
        //TODO 完成注册
        //TODO 这里将user转化成json格式传递给URL，还要将接受到的result由json格式转换回来
        String result = null;
        return result;
    }











    //TODO 通过post方法连接后端
    //TODO 这里要开启子线程来调用方法,并进行线程间的通信
    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();


//    TODO 这就是一个方法，直接调用这个方法就可以得到结果，在上面调用的时候进行传参，并且传入对应的url，就可以得到result，从而就可以进行判断
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


}
