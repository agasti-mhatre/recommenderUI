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

        List<Map<Integer, String>> eateryList = new ArrayList<Map<Integer, String>>();
        getDummyData(eateryList, 0, "The Taj");
        getDummyData(eateryList, 1, "Coromandel");
        temp.put(0, new ListProperties("Indian cuisine", eateryList));

        eateryList = new ArrayList<Map<Integer, String>>();
        getDummyData(eateryList, 0, "Fogo De Chao");
        getDummyData(eateryList, 1, "Terra Gaucha");
        getDummyData(eateryList, 2, "Brazil Steakhouse");
        temp.put(1 , new ListProperties("Fogo spots", eateryList));


        eateryList = new ArrayList<Map<Integer, String>>();
        getDummyData(eateryList, 0, "Red Lobster");
        getDummyData(eateryList, 1, "Golden Corral");
        getDummyData(eateryList, 2, "Finding Nemo");
        temp.put(2, new ListProperties("Fish ahh spots", eateryList));

        return temp;
    }

    private void getDummyData(List<Map<Integer, String>> eateryList, Integer rank, String restaurantName) {

        Map<Integer, String> tempMap = new HashMap<Integer, String>();
        tempMap.put(rank, restaurantName);
        eateryList.add(tempMap);
    }
}