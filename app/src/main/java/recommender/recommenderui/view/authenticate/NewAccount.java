package recommender.recommenderui.view.authenticate;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

import recommender.recommenderui.R;
import recommender.recommenderui.controller.backend.CreateUser;

public class NewAccount extends AppCompatActivity {

    private TextInputEditText firstName;
    private TextInputEditText lastName;
    private EditText email;
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

        firstName = findViewById(R.id.firstNameInputEditText);
        lastName = findViewById(R.id.lastNameInputEditText);
        email = findViewById(R.id.emailAddress);
        submit = initSubmit();
    }

    private Button initSubmit() {

        Button temp = findViewById(R.id.submit);

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String firstNameText = firstName.getText().toString();
                if (!firstNameText.matches(getFirstNameRegex())) {
                }
                //Do it for the other fields as well

                String lastNameText = lastName.getText().toString();
                String emailText = email.getText().toString();

                CreateUser.createAccount(firstNameText, lastNameText, emailText, getFilesDir());

            }
        });

        return temp;
    }

    private String getFirstNameRegex() {

        return "[a-zA-Z\\-]";
    }

}