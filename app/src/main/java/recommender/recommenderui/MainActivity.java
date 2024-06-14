package recommender.recommenderui;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        toolbar = initToolbar();
    }

    private BottomNavigationView initToolbar() {

        BottomNavigationView tempToolBar = findViewById(R.id.toolbar);

        NavigationBarView.OnItemSelectedListener navBarListener = initNavBarListener();
        tempToolBar.setOnItemSelectedListener(navBarListener);

        return tempToolBar;
    }

    private NavigationBarView.OnItemSelectedListener initNavBarListener() {
        return new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                boolean itemClicked = false;
                int id = menuItem.getItemId();
                if (id == R.id.yourLists) {

                    itemClicked = true;
                } else if (id == R.id.profile) {

                    itemClicked = true;
                }

                return itemClicked;
            }
        };
    }

}