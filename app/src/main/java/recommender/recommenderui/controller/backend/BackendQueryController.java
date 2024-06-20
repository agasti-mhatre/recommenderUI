package recommender.recommenderui.controller.backend;

import java.util.Map;

import recommender.recommenderui.model.ParseIntoUserProperties;
import recommender.recommenderui.model.ParseResponse;
import recommender.recommenderui.controller.view.ListProperties;

public class BackendQueryController implements ListRetrievalController<Integer, ListProperties> {

    /**
     * TEMP ---
     * Change this to connect to Spring Backend
     *
     * @return
     */
    @Override
    public Map<Integer, ListProperties> getLists() {

        ParseResponse temp = new ParseIntoUserProperties();
        return temp.getParsedResponse();
    }
}