package recommender.recommenderui.controller.backend;

import java.io.File;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import recommender.recommenderui.controller.backend.getters.GetConnection;
import recommender.recommenderui.controller.backend.runnables.CreateUserRunnable;

public class CreateUser {

    private CreateUser () {}

    public static void createAccount(File currFileDirectory, String email) {

        // Send email through request, use email to create tokens

        OkHttpClient client = new OkHttpClient();

        String accountCreateUrl = new GetConnection().createNewAccount();
        Request getAccount = new Request.Builder()
                .url(accountCreateUrl)
                .get()
                .build();

        Thread tempThread = new Thread(
                new CreateUserRunnable(client, getAccount, currFileDirectory)
        );

        tempThread.start();
    }

}