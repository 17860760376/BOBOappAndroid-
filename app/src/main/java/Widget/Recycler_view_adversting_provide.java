package Widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdemo.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.List;

import beans.Recycle_view_adverstisting;
import me.drakeet.multitype.ItemViewProvider;

public class Recycler_view_adversting_provide extends ItemViewProvider<Recycle_view_adverstisting,Recycler_view_adversting_provide.ViewHolder> {
    List<String> img;
    public Recycler_view_adversting_provide() {
    }

    @NonNull
    @Override
    protected Recycler_view_adversting_provide.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
      View view = inflater.inflate(R.layout.fragment_billboards,parent,false);
      return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, @NonNull Recycle_view_adverstisting recycle_view_adverstisting) {
        this.img=recycle_view_adverstisting.getPicture_list();
        viewHolder.mBanner.setImageLoader(new GlideImageLoader());
        viewHolder.mBanner.setIndicatorGravity(BannerConfig.CENTER);
        viewHolder.mBanner.setImages(this.img)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setDelayTime(2000).start();
        viewHolder.mBanner.setOnBannerListener(new OnBannerListener() {
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


    class ViewHolder extends RecyclerView.ViewHolder{
        Banner mBanner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.mBanner = itemView.findViewById(R.id.bannervp);
        }
    }
}
