package recommender.recommenderui;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import recommender.recommenderui.view.lists.fragments.ListsDisplayFragment;
import recommender.recommenderui.view.lists.fragments.MyProfileFragment;
import recommender.recommenderui.view.lists.listeners.BottomNavBarListener;


public class MainActivity extends AppCompatActivity {

    private Fragment listsDisplayFragment;
    private Fragment myProfileFragment;
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

        listsDisplayFragment = new ListsDisplayFragment();
        myProfileFragment = new MyProfileFragment();
        toolbar = initToolbar(savedInstanceState);
    }

    private BottomNavigationView initToolbar(Bundle savedInstanceState) {

        BottomNavigationView tempToolBar = findViewById(R.id.toolbar);

        tempToolBar.setOnItemSelectedListener(new BottomNavBarListener(getSupportFragmentManager()));

        if (savedInstanceState == null) {
            tempToolBar.setSelectedItemId(R.id.yourLists);
        }

        return tempToolBar;
    }
}