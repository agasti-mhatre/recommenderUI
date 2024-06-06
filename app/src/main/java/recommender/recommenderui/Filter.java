package recommender.recommenderui;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import org.chromium.net.CronetEngine;

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

        //fix this
        CronetEngine.Builder myBuilder = new CronetEngine.Builder(Filter.this);


        return findViewById(R.id.submit);
    }

}