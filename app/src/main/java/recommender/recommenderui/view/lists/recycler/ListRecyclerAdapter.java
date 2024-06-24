package recommender.recommenderui.view.lists.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

import recommender.recommenderui.R;
import recommender.recommenderui.controller.view.ListProperties;

/**
 * Used to display all of the lists created and saved by the user.
 */
public class ListRecyclerAdapter extends RecyclerView.Adapter<ListItemHolder> {

    private final Map<Integer, ListProperties> allLists;

    /**
     * Initialize the recycler view with all of the lists that need
     * to be displayed.
     * 
     * @param allLists - The position (Integer) and list contents for
     *                 each list.
     */
    public ListRecyclerAdapter(Map<Integer, ListProperties> allLists) {
        this.allLists = allLists;
    }

    @NonNull
    @Override
    public ListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ListItemHolder(
                LayoutInflater.from(
                        parent.getContext()
                ).inflate(R.layout.list_item_holder, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemHolder holder, int position) {
        holder.setText(allLists.get(position).getListName());
        holder.setListProperties(allLists.get(position));
    }

    @Override
    public int getItemCount() {
        return allLists.size();
    }
}
