package recommender.recommenderui.controller.backend.callbacks;

import android.util.Log;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import recommender.recommenderui.controller.backend.GetSystemFile;

public class CreateUserCallback implements Callback {

    private String failMessage;
    private File tokenFile;

    public CreateUserCallback(String callingClassName, File tokenFileDirectory) {

        failMessage = createFailMessage(callingClassName);
        tokenFile = new File(tokenFileDirectory, GetSystemFile.tokenFile());
    }

    @Override
    public void onFailure(@NonNull Call call, @NonNull IOException e) {

        Log.v(failMessage, e.toString());
    }

    @Override
    public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

        try {

            FileWriter tokenFileWriter = new FileWriter(tokenFile);
            tokenFileWriter.write(response.body().string());
            tokenFileWriter.close();
        }
        catch (IOException e) {

            Log.v(failMessage, e.toString());
        }

    }

    private String createFailMessage(String callingClassName) {

        StringBuilder buildFailMessage = new StringBuilder(callingClassName);
        buildFailMessage.append(" failed.");

        return buildFailMessage.toString();
    }
}
