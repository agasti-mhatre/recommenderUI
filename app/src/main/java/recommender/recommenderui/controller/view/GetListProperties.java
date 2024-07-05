package recommender.recommenderui.controller.view;

import java.util.Map;

import recommender.recommenderui.controller.backend.ListRetrievalQuery;

/**
 * Retrieve the list properties from a controller. This part communicates
 * with a controller and does NOT communicate with a backend server.
 */
public class GetListProperties implements ViewController<Integer, ListProperties> {
    @Override
    public Map<Integer, ListProperties> getLists() {
        return new ListRetrievalQuery().getLists();
    }
}
