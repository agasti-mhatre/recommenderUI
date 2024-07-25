package recommender.recommenderui.view.lists.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import recommender.recommenderui.R;
import recommender.recommenderui.controller.view_controller.lists.ListsImpl;

/**
 * Used to display all of the lists created and saved by the user.
 */
public class ListRecyclerAdapter extends RecyclerView.Adapter<ListItemHolder> {

    private final ListsImpl lists;

    /**
     * Initialize the recycler view with all of the lists that need
     * to be displayed.
     * 
     * @param lists - The position (Integer) and list contents for
     *                 each list.
     */
    public ListRecyclerAdapter(ListsImpl lists) {
        this.lists = lists;
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
        holder.setText(lists.getList(position).getListName());
        holder.setListProperties(lists.getList(position));
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
}
