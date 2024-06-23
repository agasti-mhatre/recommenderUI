package recommender.recommenderui.view.lists.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import recommender.recommenderui.R;
import recommender.recommenderui.controller.view.ListProperties;

public class ListContentActivity extends AppCompatActivity {

    private ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_content);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backButton = setBackButton();

        ListProperties listProperties = getIntent().getParcelableExtra("ListProperties");
        for (int i = 0; i < listProperties.getEatery().size(); i += 1) {
            Log.v("Eatery: ", listProperties.getEatery().get(i));
        }
    }

    private ImageButton setBackButton() {

        ImageButton temp = findViewById(R.id.backButton);
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        return temp;
    }
}