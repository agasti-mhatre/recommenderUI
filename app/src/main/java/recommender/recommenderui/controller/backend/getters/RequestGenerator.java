package recommender.recommenderui.controller.backend.getters;

import okhttp3.Request;

public class RequestGenerator {

    public static Request getRequest(String url) {

        return new Request.Builder()
                .url(url)
                .get()
                .build();
    }

}
