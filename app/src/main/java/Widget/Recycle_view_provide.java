package Widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appdemo.R;

import beans.Recycle_content;
import me.drakeet.multitype.ItemViewProvider;
import utility.MultiImageView;

public class Recycle_view_provide extends ItemViewProvider<Recycle_content, Recycle_view_provide.ViewHolder> {
    Context mContext;
    Recycle_view_provide(Context context){
        this.mContext = context;
    }
    @NonNull
    @Override
    protected Recycle_view_provide.ViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        View root = inflater.inflate(R.layout.item_recyclerview,parent,false);
        return new ViewHolder(root);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, @NonNull Recycle_content recycle_content_) {
        //TODO 这里面还可以添加一些点击事件




        Glide.with(this.mContext).load(recycle_content_.getMiv_head()).into(viewHolder.miv_head);
        viewHolder.musername.setText(recycle_content_.getMusername());
        viewHolder.mtime.setText(recycle_content_.getMtime());


        //TODO 这里需要设置content，主要有纯文本，文本+图片，文本+视频，转发等等，还不会设置，先放一放



        //TODO 这里先设置成纯文本的情况，传入一个String
        //TODO 这里设置点击事件，从而与后台进行交互
        viewHolder.mcontent.setText(recycle_content_.getMcontent());
//        viewHolder.mMultiImageView.setList(recycle_content_.getMulImageView());
//        viewHolder.mMultiImageView.setOnItemClickListener(new MultiImageView.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//            }
//        });
        viewHolder.mtv_zhuanfa.setText(Integer.toString(recycle_content_.getMtv_zhuanfa()));
        viewHolder.mtv_love.setText(Integer.toString(recycle_content_.getMtv_love()));
        viewHolder.mtv_wechat.setText(Integer.toString(recycle_content_.getMtv_wechat()));
        //TODO 这里只剩下点击事件了，先不考虑转发和视频的事情
    }




    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView miv_head,mmore;
        TextView musername,mtime;


        TextView mcontent;
        MultiImageView mMultiImageView;

        ImageView mzhuanfa,mlove,mwechat;
        TextView mtv_zhuanfa,mtv_love,mtv_wechat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            this.mMultiImageView=itemView.findViewById(R.id.MulImage);
            this.miv_head = itemView.findViewById(R.id.iv_head_photo);
            this.mmore=itemView.findViewById(R.id.iv_more);
            this.musername=itemView.findViewById(R.id.tv_name);
            this.mtime=itemView.findViewById(R.id.tv_time);
            this.mcontent=itemView.findViewById(R.id.content_container);
            this.mzhuanfa=itemView.findViewById(R.id.zhuanfa);
            this.mlove=itemView.findViewById(R.id.love);
            this.mwechat=itemView.findViewById(R.id.wechat);
            this.mtv_zhuanfa=itemView.findViewById(R.id.tv_zhuanfa);
            this.mtv_love=itemView.findViewById(R.id.tv_love);
            this.mtv_wechat=itemView.findViewById(R.id.tv_wechat);
        }
    }
}
