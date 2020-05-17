package View.HomePage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appdemo.R;

import Widget.Fragment_Dynamic_tuijian;
import Widget.Fragment_sousuo;

/**
 * 这是首页的主要部分，主要用来管理两个fragment
 */
public class FragmentHomePage extends Fragment {
    private View rootView;
    Fragment_Dynamic_tuijian mFragment_dynamic_tuijian;
    Fragment_sousuo mFragment_sousuo;
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState){
        if(rootView==null){
            rootView=inflater.inflate(R.layout.fragment_homepage, null);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mFragment_sousuo = new Fragment_sousuo();
        mFragment_dynamic_tuijian = new Fragment_Dynamic_tuijian();
        getChildFragmentManager()
                .beginTransaction()
                .add(R.id.release_dynamic, mFragment_dynamic_tuijian)
                .add(R.id.upsideofhome,mFragment_sousuo)
                .commit();
    }
}
