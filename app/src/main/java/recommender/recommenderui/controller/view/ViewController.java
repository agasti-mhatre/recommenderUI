package recommender.recommenderui.controller.view;

import java.util.Map;

public interface ViewController<T, U> {

    public Map<T, U> getLists();
}
