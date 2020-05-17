package Widget;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appdemo.R;
import com.example.appdemo.View.Sousuo_Activity;

/**
 * 这是主页的搜索，点进去之后就可以进入搜索界面
 */
public class Fragment_sousuo extends Fragment {
    Button mbt_sousou;
    ImageView miv_shezhi;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sousuo,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mbt_sousou = view.findViewById(R.id.sousuo);
        miv_shezhi = view.findViewById(R.id.shezhi);
        mbt_sousou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), Sousuo_Activity.class);
                startActivity(intent);
            }
        });
    }
}
