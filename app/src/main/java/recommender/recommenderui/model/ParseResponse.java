package recommender.recommenderui.model;

import java.util.Map;

/**
 * Take the response from the backend controller and put it into
 * an object-oriented format so that it can be used for the UI.
 *
 * @param <T>
 * @param <U>
 */
public interface ParseResponse<T, U> {

    public Map<T, U> getParsedResponse();
}
