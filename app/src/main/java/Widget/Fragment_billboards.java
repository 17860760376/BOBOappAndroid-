package Widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appdemo.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;
public class Fragment_billboards extends Fragment {
    private List<String> img = new ArrayList<>();
    Banner banner;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_billboards,container,false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //TODO 这里可以考虑使用okhttp从后台访问内容，或者是从网络获得图片.
        img.add("https://pic1.zhimg.com/80/v2-b0ee1ae86f677e4de0a5a2590cc6b54e_720w.jpg");
        img.add("https://pic1.zhimg.com/80/v2-4c968d7187af57bea259e15c674d60d8_720w.jpg");
        img.add("https://pic3.zhimg.com/80/v2-1cca0922856d719b46a35ba372f94271_720w.jpg");
        img.add("https://pic1.zhimg.com/80/v2-529f3d56d4182f4d64b2fd66908c4e5b_720w.jpg");
        banner = view.findViewById(R.id.bannervp);
        banner.setImageLoader(new GlideImageLoader());
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.setImages(img)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setDelayTime(2000).start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                switch (position){
                    //TODO 这里设置点击图片后的事件，图片一般都是用来做广告推销，后期再商量.
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
        });
    }
}
