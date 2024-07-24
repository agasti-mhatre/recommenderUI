package recommender.recommenderui.controller.view;

import java.util.List;

public class Lists {

    public List<ListProperties> lists;

    public ListProperties getList(int i) {

        return lists.get(i);
    }

    public int size() {

        return lists.size();
    }

}
