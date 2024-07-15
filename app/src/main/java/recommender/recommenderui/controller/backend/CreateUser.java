package recommender.recommenderui.controller.backend;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CreateUser {

    public static void createAccount(String firstName, String lastName, String email, File currFileDirectory) {

        OkHttpClient client = new OkHttpClient();

        String tempUrl = "https://01d0d2d5-fc57-4226-89c5-95ffc3903931.mock.pstmn.io/newAccount";
        Request postAccount = new Request.Builder().url(tempUrl).get().build();

        File tokenFile = new File(currFileDirectory, "tokenFile");

        Runnable tempRunnable = new Runnable() {
            @Override
            public void run() {

                client.newCall(postAccount).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NonNull Call call, @NonNull IOException e) {

                        Log.v("Get Request failed", e.getMessage());
                    }

                    @Override
                    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

                        try {

                            FileWriter tokenFileWriter = new FileWriter(tokenFile);
                            tokenFileWriter.write(response.body().string());
                            tokenFileWriter.close();
                        }
                        catch (IOException e) {

                            Log.v("File writing failed.", e.toString());
                        }
                    }
                });
            }
        };

        Thread tempThread = new Thread(tempRunnable);
        tempThread.start();

    }

}
