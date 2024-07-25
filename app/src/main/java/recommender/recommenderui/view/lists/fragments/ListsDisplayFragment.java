package recommender.recommenderui.view.lists.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import recommender.recommenderui.R;
import recommender.recommenderui.controller.view_controller.get_list_properties.GetListPropertiesImpl;
import recommender.recommenderui.view.lists.recycler.ListRecyclerAdapter;

public class ListsDisplayFragment extends Fragment {

    public ListsDisplayFragment() {
        // Required empty public constructor
    }

    public static ListsDisplayFragment newInstance() {

        ListsDisplayFragment fragment = new ListsDisplayFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View thisFragment = inflater.inflate(R.layout.fragment_lists, container, false);

        RecyclerView list = thisFragment.findViewById(R.id.listOfLists);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(new ListRecyclerAdapter((new GetListPropertiesImpl()).getLists()));

        return thisFragment;
    }
}