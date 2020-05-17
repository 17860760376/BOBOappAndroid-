package Widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdemo.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import beans.Recycle_content;
import beans.Recycle_view_adverstisting;
import me.drakeet.multitype.MultiTypeAdapter;

public class Fragment_Dynamic extends Fragment {
    //TODO 要把这个类抽象出来
     MultiTypeAdapter mAdapter;
     RecyclerView mRecyclerView;
     ArrayList contentlist;
     SimpleDateFormat mSimpleDateFormat;
     Date mdate;

//
//    //TODO 现在只是测试阶段，这是广告栏用到的一个图片数组
//    List<String> img = new ArrayList<>();
//    List<String> Mulimg = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_recyclerview,container,false);
        mRecyclerView=root.findViewById(R.id.recycle_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter.register(Recycle_view_adverstisting.class,new Recycler_view_adversting_provide());
        mAdapter.register(Recycle_content.class,new Recycle_view_provide(this.getContext()));
        mAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mAdapter);
        contentlist = new ArrayList();
        mAdapter = new MultiTypeAdapter(contentlist);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //TODO 这里把内容抽象出来，然后继承这个Fragment，来创建多个动态发布列表
//        mSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
        //获取当前时间



        //TODO 不能在这里添加数据，其他的地方都可以抽象出来
//        img.add("https://pic1.zhimg.com/80/v2-b0ee1ae86f677e4de0a5a2590cc6b54e_720w.jpg");
//        img.add("https://pic1.zhimg.com/80/v2-4c968d7187af57bea259e15c674d60d8_720w.jpg");
//        img.add("https://pic3.zhimg.com/80/v2-1cca0922856d719b46a35ba372f94271_720w.jpg");
//        img.add("https://pic1.zhimg.com/80/v2-529f3d56d4182f4d64b2fd66908c4e5b_720w.jpg");
//        Mulimg.add("https://pic2.zhimg.com/80/v2-7dac877e720005fd9d6e149d5186621a_720w.jpg");
//
//

//        mdate = new Date(System.currentTimeMillis());
//        mRecyclerView=view.findViewById(R.id.recycle_list);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        contentlist = new ArrayList();
//        mAdapter = new MultiTypeAdapter(contentlist);
//        mAdapter.register(Recycle_view_adverstisting.class,new Recycler_view_adversting_provide());
//        mAdapter.register(Recycle_content.class,new Recycle_view_provide(this.getContext()));





        //TODO 不能在这里添加数据

//        contentlist.add(new Recycle_view_adverstisting(img));


//
//        //TODO 这里是新建列表成员的地方
//        for(int i=0;i<5;i++){
//            contentlist.add(new Recycle_content("https://pic2.zhimg.com/80/v2-ec1d380a880b1667afc2e9e4ef4feccb_720w.jpg","谦哥",mSimpleDateFormat.format(mdate),"这是我发布的第"+(i+1)+"个动态",Mulimg,0,0,0));
//        }

//        mAdapter.notifyDataSetChanged();
//        mRecyclerView.setAdapter(mAdapter);
    }
}
