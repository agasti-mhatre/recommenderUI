package recommender.recommenderui.view.lists.recycler;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import recommender.recommenderui.MainActivity;
import recommender.recommenderui.R;
import recommender.recommenderui.controller.view_controller.list_properties.ListProperties;
import recommender.recommenderui.view.lists.activity.ListContentActivity;

/**
 * Holds each list category name.
 */
public class ListItemHolder extends RecyclerView.ViewHolder {

    private final CardView foodTypeHolder;
    private final TextView foodType;
    private ListProperties listProperties;

    /**
     * Initialize the ListItemHolder through by passing
     * in an inflated version of its layout. Retrieve
     * the CardView and the TextView so that they can be
     * modified according to each list category position.
     *
     * @param foodTypeContainer - Inflated layout that is
     *                          passed in from the RecyclerView.
     */
    public ListItemHolder(@NonNull View foodTypeContainer) {

        super(foodTypeContainer);

        foodTypeHolder = setFoodTypeHolder(foodTypeContainer);
        foodType = foodTypeContainer.findViewById(R.id.listName);
    }

    /**
     * Set the text view to its corresponding list item.
     *
     * @param name - The name of the list category.
     */
    public void setText(String name) {
        foodType.setText(name);
    }

    /**
     * Set the listProperties variable. This is passed
     * in via the corresponding RecyclerView.
     *
     * @param listProperties - The contents of each list including the
     *                       name of the list and its eateries.
     */
    public void setListProperties(ListProperties listProperties) {
        this.listProperties = listProperties;
    }

    private CardView setFoodTypeHolder(View foodTypeContainer) {

        CardView temp = foodTypeContainer.findViewById(R.id.listNameHolder);
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity mainActivity = (MainActivity) v.getContext();

                Intent showListContents = new Intent(mainActivity, ListContentActivity.class);
                showListContents.putExtra("ListProperties", listProperties);

                mainActivity.startActivity(showListContents);
            }
        });

        return temp;
    }

}
