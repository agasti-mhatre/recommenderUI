package recommender.recommenderui.view.lists.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

import recommender.recommenderui.R;
import recommender.recommenderui.controller.view.ListProperties;

public class ListRecyclerAdapter extends RecyclerView.Adapter<ListItemHolder> {

    private final Map<Integer, ListProperties> allRestaurants;

    public ListRecyclerAdapter(Map<Integer, ListProperties> listProperties) {
        allRestaurants = listProperties;
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
        holder.setText(allRestaurants.get(position).getListName());
    }

    @Override
    public int getItemCount() {
        return allRestaurants.size();
    }
}
