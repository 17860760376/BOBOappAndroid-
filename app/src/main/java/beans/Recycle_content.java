package beans;

import java.util.List;

public class Recycle_content {

    public Object getMiv_head() {
        return miv_head;
    }

    public void setMiv_head(Object miv_head) {
        this.miv_head = miv_head;
    }

    public String getMusername() {
        return musername;
    }

    public void setMusername(String musername) {
        this.musername = musername;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public Integer getMtv_zhuanfa() {
        return mtv_zhuanfa;
    }

    public void setMtv_zhuanfa(Integer mtv_zhuanfa) {
        this.mtv_zhuanfa = mtv_zhuanfa;
    }

    public Integer getMtv_love() {
        return mtv_love;
    }

    public void setMtv_love(Integer mtv_love) {
        this.mtv_love = mtv_love;
    }

    public Integer getMtv_wechat() {
        return mtv_wechat;
    }

    public void setMtv_wechat(Integer mtv_wechat) {
        this.mtv_wechat = mtv_wechat;
    }

    public String getMcontent() {
        return mcontent;
    }

    public void setMcontent(String mcontent) {
        this.mcontent = mcontent;
    }

    public List<String> getMulImageView() {
        return mMulImageView;
    }

    public void setMulImageView(List<String> mulImageView) {
        mMulImageView = mulImageView;
    }

    Object miv_head;
    String musername,mtime;
    Integer mtv_zhuanfa,mtv_love,mtv_wechat;
    String mcontent;
    List<String> mMulImageView;



    public Recycle_content(Object miv_head, String musername, String mtime, String mcontent, List<String> MulImageView, Integer mtv_zhuanfa, Integer mtv_love, Integer mtv_wechat) {
        this.miv_head = miv_head;
        this.musername = musername;
        this.mtime = mtime;
        this.mcontent = mcontent;
        this.mMulImageView = MulImageView;
        this.mtv_zhuanfa = mtv_zhuanfa;
        this.mtv_love = mtv_love;
        this.mtv_wechat = mtv_wechat;
    }

    @Override
    public String toString() {
        return "Recycle_content_text{" +
                "miv_head=" + miv_head +
                ", musername='" + musername + '\'' +
                ", mtime='" + mtime + '\'' +
                ", mtv_zhuanfa=" + mtv_zhuanfa +
                ", mtv_love=" + mtv_love +
                ", mtv_wechat=" + mtv_wechat +
                ", mcontent='" + mcontent + '\'' +
                ", mMulImageView=" + mMulImageView +
                '}';
    }
}
