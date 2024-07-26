package recommender.recommenderui;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import recommender.recommenderui.view.lists.listeners.BottomNavBarListener;


public class MainActivity extends AppCompatActivity {


    private NavigationBarView.OnItemSelectedListener bottomNavBarListener;
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

        bottomNavBarListener = new BottomNavBarListener(getSupportFragmentManager());
        toolbar = initToolbar(savedInstanceState);
    }

    private BottomNavigationView initToolbar(Bundle savedInstanceState) {

        BottomNavigationView tempToolBar = findViewById(R.id.toolbar);

        tempToolBar.setOnItemSelectedListener(bottomNavBarListener);

        if (savedInstanceState == null) {
            tempToolBar.setSelectedItemId(R.id.yourLists);
        }

        return tempToolBar;
    }
}