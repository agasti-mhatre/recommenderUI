package recommender.recommenderui.view.authenticate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import recommender.recommenderui.MainActivity;
import recommender.recommenderui.R;

public class Authenticator extends AppCompatActivity {

    private TextView createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_authenticator);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        createAccount = initCreateAccount();

        // Change this with a check: If the user has a valid token, proceed to Main, otherwise remain on authentication page
        //if(true) {

        //    startActivity(new Intent(Authenticator.this, MainActivity.class));
        //}
    }

    private TextView initCreateAccount() {

        TextView temp = findViewById(R.id.createAccount);

        temp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                startActivity(new Intent(Authenticator.this, NewAccount.class));
            }
        });

        return temp;
    }

}