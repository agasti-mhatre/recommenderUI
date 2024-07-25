package recommender.recommenderui.view.lists.recycler;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import recommender.recommenderui.R;
import recommender.recommenderui.controller.view_controller.list_properties.ListProperties;

/**
 * Recycler for each list's contents. Each list will contain a number
 * of eateries which should be cycled through via this adapter.
 */
public class EateryRecyclerAdapter extends RecyclerView.Adapter<EateryHolder>{

    private final ListProperties listProperties;

    /**
     * Initialize the object with the properties of the list
     *
     * @param listProperties
     */
    public EateryRecyclerAdapter(ListProperties listProperties) {
        this.listProperties = listProperties;
    }

    @NonNull
    @Override
    public EateryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EateryHolder(
                LayoutInflater.from(
                        parent.getContext()
                ).inflate(R.layout.eatery_holder, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull EateryHolder holder, int position) {
        holder.setRestaurantName(listProperties.getEatery(position));
    }

    @Override
    public int getItemCount() {
        return listProperties.size();
    }
}
