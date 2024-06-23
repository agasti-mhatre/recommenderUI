package recommender.recommenderui.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import recommender.recommenderui.controller.view.ListProperties;

public class ParseIntoListProperties implements ParseResponse<Integer, ListProperties>{

    /**
     * TEMP ---
     * Change this to connect to take in a JSON object and parse it into fields
     *
     * @return
     */
    @Override
    public Map<Integer, ListProperties> getParsedResponse() {

        Map<Integer, ListProperties> temp = new HashMap<Integer, ListProperties>();

        Map<Integer, String> eateries = new HashMap<Integer, String>();
        eateries.put(0, "The Taj");
        eateries.put(1, "Coromandel");
        temp.put(0, new ListProperties("Indian cuisine", eateries));

        eateries = new HashMap<Integer, String>();
        eateries.put(0, "Fogo De Chao");
        eateries.put(1, "Terra Gaucha");
        eateries.put(2, "Brazil Steakhouse");
        temp.put(1 , new ListProperties("Fogo spots", eateries));


        eateries = new HashMap<Integer, String>();
        eateries.put(0, "Red Lobster");
        eateries.put(1, "Golden Corral");
        eateries.put(2, "Finding Nemo");
        temp.put(2, new ListProperties("Fish ahh spots", eateries));

        return temp;
    }
}