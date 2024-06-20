package recommender.recommenderui.model;

import java.util.Map;

public interface ParseResponse<T, U> {

    public Map<T, U> getParsedResponse();
}
