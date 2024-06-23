package recommender.recommenderui.view.lists.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import recommender.recommenderui.R;

public class EateryHolder extends RecyclerView.ViewHolder {

    private TextView restaurant_name;
    public EateryHolder(@NonNull View itemView) {
        super(itemView);

        restaurant_name = itemView.findViewById(R.id.eateryName);
    }

    public void setRestaurantName(String restaurantName) {
        restaurant_name.setText(restaurantName);
    }
}
