package recommender.recommenderui.controller.backend;

import android.util.Log;

import androidx.annotation.NonNull;

import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CreateUser {

    public static void createAccount(String firstName, String lastName, String email) {

        OkHttpClient client = new OkHttpClient();

        String tempUrl = "https://01d0d2d5-fc57-4226-89c5-95ffc3903931.mock.pstmn.io/newAccount";
        Request postAccount = new Request.Builder().url(tempUrl).get().build();

        Runnable tempRunnable = new Runnable() {
            @Override
            public void run() {

                client.newCall(postAccount).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {

                        Log.d("Get Request failed", e.getMessage());
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                        Log.d("Response: ", response.body().string());
                    }
                });
            }
        };

        Thread tempThread = new Thread(tempRunnable);
        tempThread.start();

    }

}
