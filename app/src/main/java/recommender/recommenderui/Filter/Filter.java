package recommender.recommenderui.Filter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import org.chromium.net.CronetEngine;
import org.chromium.net.UrlRequest;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

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

        Button currSubmit = findViewById(R.id.submit);

        CronetEngine cronetEngine = (new CronetEngine.Builder(Filter.this)).build();
        Executor networkExecutor = Executors.newSingleThreadExecutor();

        UrlRequest.Builder requestBuilder = cronetEngine.newUrlRequestBuilder(
                "http://localhost:8080/test", new FilterRequestCallback(), networkExecutor
        );

        UrlRequest getRequest = requestBuilder.build();
        currSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getRequest.start();
            }
        });

        return currSubmit;
    }

}