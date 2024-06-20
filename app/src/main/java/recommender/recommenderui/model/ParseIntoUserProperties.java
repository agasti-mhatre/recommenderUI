package recommender.recommenderui.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import recommender.recommenderui.controller.view.ListProperties;

public class ParseIntoUserProperties implements ParseResponse<Integer, ListProperties>{

    /**
     * TEMP ---
     * Change this to connect to take in a JSON object and parse it into fields
     *
     * @return
     */
    @Override
    public Map<Integer, ListProperties> getParsedResponse() {

        Map<Integer, ListProperties> temp = new HashMap<Integer, ListProperties>();

        temp.put(0, new ListProperties("Indian cuisine"));
        temp.put(1 , new ListProperties("Fogo spots"));
        temp.put(2, new ListProperties("Fish ahh spots"));

        return temp;
    }
}