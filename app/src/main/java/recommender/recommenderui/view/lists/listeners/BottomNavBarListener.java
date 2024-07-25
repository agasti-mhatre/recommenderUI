package recommender.recommenderui.view.lists.listeners;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.navigation.NavigationBarView;

import java.util.HashMap;
import java.util.Map;

import recommender.recommenderui.R;
import recommender.recommenderui.view.lists.fragments.ListsDisplayFragment;
import recommender.recommenderui.view.lists.fragments.MyProfileFragment;

public class BottomNavBarListener implements NavigationBarView.OnItemSelectedListener {

    private FragmentManager fragmentManager;
    private Fragment listsDisplayFragment;
    private Fragment myProfileFragment;
    private Map<Integer, Fragment> fragmentMap;

    public BottomNavBarListener(FragmentManager fragmentManager) {

        this.fragmentManager = fragmentManager;

        listsDisplayFragment = new ListsDisplayFragment();
        myProfileFragment = new MyProfileFragment();

        fragmentMap = initMap();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id = menuItem.getItemId();

        if (!fragmentMap.containsKey(id)) {
            return false;
        }

        displayFragment(R.id.mainFragmentContainer, fragmentMap.get(id));

        return true;
    }

    private Map<Integer, Fragment> initMap() {

        Map<Integer, Fragment> tempMap = new HashMap<Integer, Fragment>();

        tempMap.put(R.id.yourLists, listsDisplayFragment);
        tempMap.put(R.id.profile, myProfileFragment);

        return tempMap;
    }

    private void displayFragment(int containerID, Fragment fragment) {

        fragmentManager.beginTransaction().replace(containerID, fragment).commit();
    }
}
