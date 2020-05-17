package View.HomePage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.example.appdemo.R;

import View.EnterPage.FragmentEnterPage;
import View.FoundPage.FragmentFoundPage;
import View.MinePage.FragmentMinePage;
import View.PositionPage.FragmentPositionPage;

public class Maininterface_activity extends FragmentActivity {
    //TODO 这是底部的菜单栏
    private Widget.FragmentTabHost mFragmentTabHost;
//    private FragmentTabHost mFragmentTabHost;
    private String texts[]={"首页","发现","阵地","入驻","我的"};
    private int imageButton[]={R.drawable.bt_home_selector,
    R.drawable.bt_found_selector,R.drawable.bt_position_selector,
    R.drawable.bt_enter_selector,R.drawable.bt_mine_selector};

    //TODO 每个菜单栏上方的fragment
    private Class fragmentArray[]={
            FragmentHomePage.class, FragmentFoundPage.class, FragmentPositionPage.class, FragmentEnterPage.class, FragmentMinePage.class
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maininterface_activity);
        mFragmentTabHost = findViewById(android.R.id.tabhost);
        mFragmentTabHost.setup(this,getSupportFragmentManager(),
                R.id.maincontent);
        for(int i=0;i<texts.length;i++){
            TabHost.TabSpec spec = mFragmentTabHost.newTabSpec(texts[i]).setIndicator(getView(i));
            mFragmentTabHost.addTab(spec,fragmentArray[i],null);
            mFragmentTabHost.getTabWidget().getChildAt(i);
        }
    }
    private View getView(int i){
        View view=View.inflate(Maininterface_activity.this,R.layout.layout_tabcontent,null);
        ImageView imageView=view.findViewById(R.id.tabcontent_image);
        TextView textView = view.findViewById(R.id.tabcontent_text);
        imageView.setImageResource(imageButton[i]);
        textView.setText(texts[i]);
        return  view;
    }
}
