package recommender.recommenderui.Filter;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import recommender.recommenderui.R;

public class Filter extends AppCompatActivity {

    private TextInputEditText textInputFoodType;
    private TextInputEditText textInputRadius;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_filter);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textInputFoodType = initTextInputFoodType();
        textInputRadius = initTextInputRadius();

        submit = initSubmit(textInputFoodType, textInputRadius);
    }

    private TextInputEditText initTextInputFoodType() {
        return findViewById(R.id.textInputFoodType);
    }

    private TextInputEditText initTextInputRadius() {
        return findViewById(R.id.textInputRadius);
    }

    private Button initSubmit(TextInputEditText... editTexts) {

        //TEMP
        String url = "https://jsonplaceholder.typicode.com/posts";

        // Create OkHttpClient instance
        OkHttpClient client = new OkHttpClient();

        // Create a request
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Make an asynchronous GET request
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("Network request failed", e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (!response.isSuccessful()) {
                    Log.d("Unexpected code ", response.toString());
                } else {
                    String responseData = response.body() != null ? response.body().string() : "No response data";
                    Log.d("Response: ", responseData);
                }
            }
        });
        //TEMP

        Button currSubmit = findViewById(R.id.submit);


        return currSubmit;
    }

}