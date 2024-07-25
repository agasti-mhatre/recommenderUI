package recommender.recommenderui.controller.view_controller.lists;

import java.util.List;

import recommender.recommenderui.controller.view_controller.list_properties.ListPropertiesImpl;


public class ListsImpl implements Lists<ListPropertiesImpl> {

    public List<ListPropertiesImpl> lists;

    @Override
    public ListPropertiesImpl getList(int i) {

        return lists.get(i);
    }

    @Override
    public int size() {

        return lists.size();
    }

}
