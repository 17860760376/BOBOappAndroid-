package Widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.example.appdemo.R;

/**
 * TODO 这个是一个具体的搜索界面的实现
 */
public class Fragment_sousuo_1 extends Fragment {
    SearchView mSearchView;
    ImageView mImageView;
    TextView mTextView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sousuo_1,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mSearchView = view.findViewById(R.id.sousuo);
        mImageView = view.findViewById(R.id.fanhui);
        mTextView = view.findViewById(R.id.sousuobutton);
        mSearchView.setQueryHint("把自己做成表情包");
        mSearchView.setIconified(false);
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //TODO 这里处理一个监听回调，根据query来查询数据库，并通知下部的fragment，来更新，并且更新历史搜索
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //TODO 这里可以进行搜索内容，模糊查询，进行实时更新）
                return false;
            }
        });
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
