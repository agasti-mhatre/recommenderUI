package recommender.recommenderui.controller.backend.callbacks;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import recommender.recommenderui.controller.view_controller.lists.ListsImpl;

public class ListRetreivalCallback implements Callback {

    private ListsImpl lists;
    private CountDownLatch latch;

    public ListRetreivalCallback(CountDownLatch latch) {

        this.latch = latch;
    }

    public ListsImpl getLists() {
        return lists;
    }

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
}
