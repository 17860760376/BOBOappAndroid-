package beans;

import java.util.List;

public class Recycle_view_adverstisting {
    @Override
    public String toString() {
        return "Recycle_view_adverstisting{" +
                "picture_list=" + picture_list +
                '}';
    }

    public Recycle_view_adverstisting(List<String> picture_list) {
        this.picture_list = picture_list;
    }

    List<String> picture_list;

    public List<String> getPicture_list() {
        return picture_list;
    }

    public void setPicture_list(List<String> picture_list) {
        this.picture_list = picture_list;
    }
}
