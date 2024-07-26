package recommender.recommenderui.controller.backend.listRetrieval;

import android.util.Log;

import java.util.concurrent.CountDownLatch;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import recommender.recommenderui.controller.backend.getters.GetConnection;
import recommender.recommenderui.controller.backend.callbacks.ListRetreivalCallback;
import recommender.recommenderui.controller.backend.runnables.ListRetrievalRunnable;
import recommender.recommenderui.controller.view_controller.lists.ListsImpl;

public class ListRetrievalQuery implements ListRetrievalController {

    private ListsImpl lists;
    private ListRetreivalCallback listRetreivalCallback;

    @Override
    public ListsImpl getLists() {

        CountDownLatch latch = new CountDownLatch(1);

        listRetreivalCallback = new ListRetreivalCallback(latch);

        OkHttpClient client = new OkHttpClient();
        String listRetrievalUrl = new GetConnection().getLists();
        Request getListReq = new Request.Builder()
                .url(listRetrievalUrl)
                .get()
                .build();

        Thread requestThread = new Thread(new ListRetrievalRunnable(client, getListReq, listRetreivalCallback));
        requestThread.start();

        try {

            latch.await();
        } catch (InterruptedException e) {

            Log.v("InterruptedException requestThread", e.toString());
        }

        return listRetreivalCallback.getLists();
    }

}