package recommender.recommenderui.lists.recycler;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import recommender.recommenderui.R;

public class ListRecyclerAdapter extends RecyclerView.Adapter<ListItemHolder> {

    private final List<String> allRestaurants;

    public ListRecyclerAdapter() {
        allRestaurants = new ArrayList();
        allRestaurants.add("Temp");
    }

    @NonNull
    @Override
    public ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListItemHolder(
                LayoutInflater.from(
                        parent.getContext()
                ).inflate(R.layout.restaurant_name_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemHolder holder, int position) {
        holder.setText(allRestaurants.get(position));
    }

    @Override
    public int getItemCount() {
        return allRestaurants.size();
    }
}
