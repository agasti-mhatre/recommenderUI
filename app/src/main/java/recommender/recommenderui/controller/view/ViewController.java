package recommender.recommenderui.controller.view;

import java.util.Map;

/**
 * Use this controller to communicate with the backend controller.
 * This controller is responsible for passing information from
 * the backend controller to view components with the UI. Serves
 * as a layer between backend communication and the UI in order
 * to decouple the two.
 *
 * @param <T>
 * @param <U>
 */
public interface ViewController<T, U> {

    public Map<T, U> getLists();
}
