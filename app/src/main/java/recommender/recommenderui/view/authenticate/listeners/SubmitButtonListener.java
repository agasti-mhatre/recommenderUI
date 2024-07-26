package recommender.recommenderui.view.authenticate.listeners;

import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import recommender.recommenderui.R;
import recommender.recommenderui.controller.backend.CreateUser;

public class SubmitButtonListener implements View.OnClickListener {

    private AppCompatActivity newAccount;
    private TextInputEditText firstName;
    private TextInputEditText lastName;
    private EditText email;

    public SubmitButtonListener(AppCompatActivity newAccount) {

        this.newAccount = newAccount;
        firstName = newAccount.findViewById(R.id.firstNameInputEditText);
        lastName = newAccount.findViewById(R.id.lastNameInputEditText);
        email = newAccount.findViewById(R.id.emailAddress);
    }

    @Override
    public void onClick(View v) {

        // Do input validation for all of the text fields

        CreateUser.createAccount(newAccount.getFilesDir(), email.getText().toString());
    }
}
