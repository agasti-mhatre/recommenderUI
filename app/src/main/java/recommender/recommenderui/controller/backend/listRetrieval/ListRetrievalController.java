package recommender.recommenderui.controller.backend.listRetrieval;

import recommender.recommenderui.controller.view_controller.lists.Lists;

/**
 * Connect to the backend server and retrieve all lists and their data
 * pertaining to the current user.
 *
 */
public interface ListRetrievalController {

    /**
     * Return the list information for each list.
     *
     * @return Lists - The list of lists.
     */
    public Lists getLists();
}