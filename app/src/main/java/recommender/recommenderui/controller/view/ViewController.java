package recommender.recommenderui.controller.view;

/**
 * Use this controller to communicate with the backend controller.
 * This controller is responsible for passing information from
 * the backend controller to view components with the UI. Serves
 * as a layer between backend communication and the UI in order
 * to decouple the two.
 *
 * @param <T>
 */
public interface ViewController<T> {

    public T getLists();
}
