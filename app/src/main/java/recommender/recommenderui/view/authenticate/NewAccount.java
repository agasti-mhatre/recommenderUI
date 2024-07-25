package recommender.recommenderui.view.authenticate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import recommender.recommenderui.R;
import recommender.recommenderui.view.authenticate.listeners.SubmitButtonListener;

public class NewAccount extends AppCompatActivity {

    private View.OnClickListener submitButtonListener;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        submitButtonListener = new SubmitButtonListener(this);
        initSubmit();
    }

    private void initSubmit() {

        submit = findViewById(R.id.submit);
        submit.setOnClickListener(submitButtonListener);
    }

}