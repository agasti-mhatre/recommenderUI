package recommender.recommenderui.controller.backend.runnables;

import java.io.File;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import recommender.recommenderui.controller.backend.CreateUser;
import recommender.recommenderui.controller.backend.callbacks.CreateUserCallback;

public class CreateUserRunnable implements Runnable {

    private OkHttpClient client;
    private Request request;
    private File tokenFileDirectory;

    public CreateUserRunnable(OkHttpClient client, Request request, File tokenFileDirectory) {

        this.client = client;
        this.request = request;
        this.tokenFileDirectory = tokenFileDirectory;
    }

    @Override
    public void run() {

        client.newCall(request).enqueue(
                new CreateUserCallback(CreateUser.class.getName(), tokenFileDirectory)
        );
    }
}
