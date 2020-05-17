package Widget;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appdemo.R;

import java.util.ArrayList;
import java.util.List;

import utility.JudgePhone;

public class EditWatcher  {
    private List<EditText> mEditTextList = new ArrayList<>();
    private Button bt_register;
    private TextView tv_note;
    private Context mContext;
   public  EditWatcher getInstance(){
       return new EditWatcher();
   }
   public EditWatcher setButton(Button button){
       this.bt_register = button;
       return this;
   }
   public EditWatcher setTextView(TextView textView){
       this.tv_note = textView;
       return this;
   }
   public EditWatcher setContent(Context content){
       this.mContext = content;
       return this;
   }
   public EditWatcher addEditList(EditText editText){
       mEditTextList.add(editText);
       return this;
   }
   public void build(){
        setWatcher();
   }
   int i;
   private void setWatcher(){
       for(i=0;i<mEditTextList.size();i++){
           mEditTextList.get(i).addTextChangedListener(new TextWatcher() {
               @Override
               public void beforeTextChanged(CharSequence s, int start, int count, int after) {

               }

               @Override
               public void onTextChanged(CharSequence s, int start, int before, int count) {

               }

               @Override
               public void afterTextChanged(Editable s) {
                    boolean fg = true;
                    for(int j=0;j<mEditTextList.size();j++){
                        String tm = mEditTextList.get(j).getText().toString();
                        if(j==0){
                            if(!JudgePhone.isPhoneNumber(tm)){
                                fg=false;break;
                            }
                        }
                        else if(j==2){
                            if(tm.length()<5){
                                fg=false;break;
                            }
                        }
                        else {
                            if(tm.length()==0){
                                fg=false;break;
                            }
                        }
                    }
                    if(!fg){
                        bt_register.setClickable(false);
                        bt_register.setBackground(bt_register.getResources().getDrawable(R.drawable.bg_resgisterbt));
                    }
                    else{
                        bt_register.setClickable(true);
                        bt_register.setBackground(bt_register.getResources().getDrawable(R.drawable.bg_resigsteralready));

                    }
               }
           });
       }
   }
}
