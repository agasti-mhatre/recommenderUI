package recommender.recommenderui.view.lists.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import recommender.recommenderui.R;
import recommender.recommenderui.controller.view.ListProperties;
import recommender.recommenderui.view.lists.recycler.EateryRecyclerAdapter;

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

        RecyclerView eateryList = setEateryList(getIntent().getParcelableExtra("ListProperties"));

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

    private RecyclerView setEateryList(ListProperties listProperties) {

        RecyclerView temp = findViewById(R.id.eateryRank);

        temp.setLayoutManager(new LinearLayoutManager(ListContentActivity.this));
        temp.setAdapter(new EateryRecyclerAdapter(listProperties));

        return temp;
    }
}