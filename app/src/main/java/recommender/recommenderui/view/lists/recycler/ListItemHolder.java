package recommender.recommenderui.view.lists.recycler;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import recommender.recommenderui.MainActivity;
import recommender.recommenderui.R;
import recommender.recommenderui.view.lists.activity.ListContentActivity;

public class ListItemHolder extends RecyclerView.ViewHolder {

    private final CardView foodTypeHolder;
    private final TextView foodType;

    public ListItemHolder(@NonNull View foodTypeContainer) {

        super(foodTypeContainer);

        foodTypeHolder = setFoodTypeHolder(foodTypeContainer);
        foodType = foodTypeContainer.findViewById(R.id.restaurant_name);
    }

    public void setText(String name) {
        foodType.setText(name);
    }

    private CardView setFoodTypeHolder(View foodTypeContainer) {

        CardView temp = foodTypeContainer.findViewById(R.id.restaurantNameHolder);
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity mainActivity = (MainActivity) v.getContext();
                mainActivity.startActivity(new Intent(mainActivity, ListContentActivity.class));

            }
        });

        return temp;
    }

}
