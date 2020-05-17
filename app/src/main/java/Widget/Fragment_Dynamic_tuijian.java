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
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.Recycle_content;
import beans.Recycle_view_adverstisting;
import me.drakeet.multitype.MultiTypeAdapter;

/**
 * 这是主页推荐的动态列表
 */
public class Fragment_Dynamic_tuijian extends Fragment {
    MultiTypeAdapter mAdapter;
    RecyclerView mRecyclerView;
    ArrayList contentlist;
    RefreshLayout refreshLayout;
    SimpleDateFormat mSimpleDateFormat;
    Date mdate;
    List<String> guanggaoimg = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");// HH:mm:ss



        //TODO 设置上拉和下拉刷新
        refreshLayout = view.findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(1400/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(1400/*,false*/);//传入false表示加载失败
            }
        });
        refreshLayout.setRefreshHeader(new BezierRadarHeader(this.getContext()).setEnableHorizontalDrag(true));//设置 Footer 为 球脉冲 样式
        refreshLayout.setRefreshFooter(new BallPulseFooter(this.getContext()).setSpinnerStyle(SpinnerStyle.Scale));




        guanggaoimg.add("https://pic1.zhimg.com/80/v2-b0ee1ae86f677e4de0a5a2590cc6b54e_720w.jpg");
        guanggaoimg.add("https://pic1.zhimg.com/80/v2-4c968d7187af57bea259e15c674d60d8_720w.jpg");
        guanggaoimg.add("https://pic3.zhimg.com/80/v2-1cca0922856d719b46a35ba372f94271_720w.jpg");
        guanggaoimg.add("https://pic1.zhimg.com/80/v2-529f3d56d4182f4d64b2fd66908c4e5b_720w.jpg");
        mdate = new Date(System.currentTimeMillis());
        mRecyclerView=view.findViewById(R.id.recycle_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        contentlist = new ArrayList();
        mAdapter = new MultiTypeAdapter(contentlist);
        mAdapter.register(Recycle_view_adverstisting.class,new Recycler_view_adversting_provide());
        mAdapter.register(Recycle_content.class,new Recycle_view_provide(this.getContext()));

        mRecyclerView.setAdapter(mAdapter);
        contentlist.add(new Recycle_view_adverstisting(guanggaoimg));
        mAdapter.notifyDataSetChanged();
    }
}
