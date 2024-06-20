package recommender.recommenderui.controller.view;

import java.util.Map;

import recommender.recommenderui.controller.backend.BackendQueryController;

public class GetUserProperties implements ViewController<Integer, ListProperties> {
    @Override
    public Map<Integer, ListProperties> getLists() {
        return new BackendQueryController().getLists();
    }
}
