package recommender.recommenderui.controller.backend.runnables;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class ListRetrievalRunnable implements Runnable {

    private OkHttpClient client;
    private Request request;
    private Callback callback;

    public ListRetrievalRunnable(OkHttpClient client, Request request, Callback callback) {

        this.client = client;
        this.request = request;
        this.callback = callback;
    }

    @Override
    public void run() {

        client.newCall(request).enqueue(callback);
    }
}
