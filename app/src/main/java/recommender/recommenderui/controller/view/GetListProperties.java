package recommender.recommenderui.controller.view;

import recommender.recommenderui.controller.backend.ListRetrievalQuery;

/**
 * Retrieve the list properties from a controller. This part communicates
 * with a controller and does NOT communicate with a backend server.
 */
public class GetListProperties implements ViewController<Lists> {
    @Override
    public Lists getLists() {
        return new ListRetrievalQuery().getLists();
    }
}
