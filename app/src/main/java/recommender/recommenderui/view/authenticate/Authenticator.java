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


    private Button goToMain;

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

        goToMain = tempInitializer();
    }

    private TextView initCreateAccount() {

        TextView temp = findViewById(R.id.createAccount);

        temp.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


            }
        });

        return temp;
    }

    private Button tempInitializer() {

        Button temp = findViewById(R.id.temp);

        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Authenticator.this, MainActivity.class));
            }
        });

        return temp;
    }
}