package recommender.recommenderui.controller.view_controller.get_list_properties;

import recommender.recommenderui.controller.backend.listRetrieval.ListRetrievalQuery;
import recommender.recommenderui.controller.view_controller.lists.ListsImpl;

/**
 * Retrieve the list properties from a controller. This part communicates
 * with a controller and does NOT communicate with a backend server.
 */
public class GetListPropertiesImpl implements GetListProperties<ListsImpl> {
    @Override
    public ListsImpl getLists() {
        return new ListRetrievalQuery().getLists();
    }
}
