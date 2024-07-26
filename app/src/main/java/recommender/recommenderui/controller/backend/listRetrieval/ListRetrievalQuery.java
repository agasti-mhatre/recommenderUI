package recommender.recommenderui.controller.backend.listRetrieval;

import android.util.Log;

import androidx.annotation.NonNull;


import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import recommender.recommenderui.controller.backend.GetConnection;
import recommender.recommenderui.controller.view_controller.lists.ListsImpl;

public class ListRetrievalQuery implements ListRetrievalController {

    private ListsImpl lists;

    @Override
    public ListsImpl getLists() {

        CountDownLatch latch = new CountDownLatch(1);
        Runnable sendRequest = createRunnable(latch);

        Thread requestThread = new Thread(sendRequest);
        requestThread.start();

        try {

            latch.await();
        } catch (InterruptedException e) {

            Log.v("InterruptedException requestThread", e.toString());
        }

        return lists;
    }

    private Runnable createRunnable(CountDownLatch latch) {

        OkHttpClient client = new OkHttpClient();

        String listRetrievalUrl = new GetConnection().getLists();

        Request getListReq = new Request.Builder()
                .url(listRetrievalUrl)
                .get()
                .build();

        return new Runnable() {
            @Override
            public void run() {

                client.newCall(getListReq).enqueue(getCallback(latch));
            }
        };
    }

    private Callback getCallback(CountDownLatch latch) {
        return new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

                Log.v("Error retrieving lists", e.toString());
                latch.countDown();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                String responseBody = response.body().string();

                lists = (new Gson()).fromJson(responseBody, ListsImpl.class);
                latch.countDown();
            }
        };
    }

}