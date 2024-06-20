package recommender.recommenderui.view.lists;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import recommender.recommenderui.R;
import recommender.recommenderui.controller.view.GetUserProperties;
import recommender.recommenderui.view.lists.recycler.ListRecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListsDisplayFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListsDisplayFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public ListsDisplayFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListsFragment.
     */
    public static ListsDisplayFragment newInstance(String param1, String param2) {
        ListsDisplayFragment fragment = new ListsDisplayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View thisFragment = inflater.inflate(R.layout.fragment_lists, container, false);

        RecyclerView list = thisFragment.findViewById(R.id.listOfLists);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(new ListRecyclerAdapter((new GetUserProperties()).getLists()));

        return thisFragment;
    }
}