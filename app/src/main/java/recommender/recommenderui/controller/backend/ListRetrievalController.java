package recommender.recommenderui.controller.backend;

import java.util.Map;

/**
 * Connect to the backend server and retrieve all lists and their data
 * pertaining to the current user.
 *
 * @param <T> The key used to access the uth list
 * @param <U> A data structure representing a single lists data
 */
public interface ListRetrievalController<T, U> {

    /**
     * Return the list information for each list.
     *
     * @return listMap. T represents the position of each list within the view,
     * U represents the list information.
     */
    public Map<T, U> getLists();
}