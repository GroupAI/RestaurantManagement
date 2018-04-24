package bdnath.lictproject.info.restaurantmanagement.FoodPackage;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bdnath.lictproject.info.restaurantmanagement.R;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodViewHolder> {
    private List<FoodClass> foodList;
    public FoodListAdapter(List<FoodClass>foodList) {
        this.foodList=foodList;
    }

    @NonNull
    @Override
    public FoodListAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.food_row_view, parent,false);
        return new FoodListAdapter.FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListAdapter.FoodViewHolder holder, int position) {
        holder.itemName.setText(foodList.get(position).getFoodName());
        holder.price.setText(foodList.get(position).getFoodPrice());
        holder.itemDetails.setText(foodList.get(position).getFoodDetails());

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class FoodViewHolder extends RecyclerView.ViewHolder{
        TextView itemName;
        TextView price;
        TextView itemDetails;
        ImageView foodImage;
        public FoodViewHolder(final View itemView) {
            super(itemView);

            itemName=itemView.findViewById(R.id.itemName);
            price=itemView.findViewById(R.id.price);
            itemDetails=itemView.findViewById(R.id.itemDetails);
            foodImage=itemView.findViewById(R.id.foodImage);
        }
    }
}
