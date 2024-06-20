package recommender.recommenderui.controller.backend;

import java.util.Map;

public interface ListRetrievalController<T, U> {

    public Map<T, U> getLists();
}