package recommender.recommenderui.view.lists.recycler;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;

import recommender.recommenderui.MainActivity;
import recommender.recommenderui.R;
import recommender.recommenderui.controller.view.ListProperties;
import recommender.recommenderui.view.lists.activity.ListContentActivity;

public class ListItemHolder extends RecyclerView.ViewHolder {

    private final CardView foodTypeHolder;
    private final TextView foodType;
    private ListProperties listProperties;

    public ListItemHolder(@NonNull View foodTypeContainer) {

        super(foodTypeContainer);

        foodTypeHolder = setFoodTypeHolder(foodTypeContainer);
        foodType = foodTypeContainer.findViewById(R.id.restaurant_name);
    }

    public void setText(String name) {
        foodType.setText(name);
    }

    public void setListProperties(ListProperties listProperties) {
        this.listProperties = listProperties;
    }

    private CardView setFoodTypeHolder(View foodTypeContainer) {

        CardView temp = foodTypeContainer.findViewById(R.id.restaurantNameHolder);
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
