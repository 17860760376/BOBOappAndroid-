package Widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appdemo.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import beans.Recycle_content;
import beans.Recycle_view_adverstisting;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * TODO 这是主页关注用户的动态列表
 */
public class Fragment_Dynamic_guanzhu extends Fragment_Dynamic {
    MultiTypeAdapter mAdapter;
    RecyclerView mRecyclerView;
    ArrayList contentlist;
    SimpleDateFormat mSimpleDateFormat;
    Date mdate;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss
        mdate = new Date(System.currentTimeMillis());
        mRecyclerView=view.findViewById(R.id.recycle_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        contentlist = new ArrayList();
        mAdapter = new MultiTypeAdapter(contentlist);
        mAdapter.register(Recycle_view_adverstisting.class,new Recycler_view_adversting_provide());
        mAdapter.register(Recycle_content.class,new Recycle_view_provide(this.getContext()));
        mAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mAdapter);
        //TODO 回调一下来调用数据
    }
}
