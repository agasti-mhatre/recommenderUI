package recommender.recommenderui.controller.backend;

import android.util.Log;

import java.io.File;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import recommender.recommenderui.controller.backend.callbacks.CreateUserCallback;

public class CreateUser {

    private CreateUser () {}

    public static void createAccount(File currFileDirectory, String email) {

        // Send email through request, use email to create tokens

        Runnable tempRunnable = createRunnable(currFileDirectory);

        Thread tempThread = new Thread(tempRunnable);
        tempThread.start();

    }

    private static Runnable createRunnable(File currFileDirectory) {

        OkHttpClient client = new OkHttpClient();

        String accountCreateUrl = new GetConnection().createNewAccount();
        Request getAccount = new Request.Builder()
                .url(accountCreateUrl)
                .get()
                .build();

        return new Runnable() {
            @Override
            public void run() {

                client.newCall(getAccount).enqueue(new CreateUserCallback(CreateUser.class.getName(), currFileDirectory));
            }
        };
    }

}