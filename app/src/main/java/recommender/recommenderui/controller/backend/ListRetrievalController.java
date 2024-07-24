package recommender.recommenderui.controller.backend;

/**
 * Connect to the backend server and retrieve all lists and their data
 * pertaining to the current user.
 *
 * @param <T> The list of lists
 */
public interface ListRetrievalController<T> {

    /**
     * Return the list information for each list.
     *
     * @return T
     */
    public T getLists();
}