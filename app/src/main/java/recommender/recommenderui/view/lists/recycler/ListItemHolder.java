package recommender.recommenderui.view.lists.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import recommender.recommenderui.R;

public class ListItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final TextView restaurantName;

    public ListItemHolder(@NonNull View restaurantName) {

        super(restaurantName);
        this.restaurantName = restaurantName.findViewById(R.id.restaurant_name);
    }

    public void setText(String name) {
        restaurantName.setText(name);
    }

    @Override
    public void onClick(View v) {

    }
}
