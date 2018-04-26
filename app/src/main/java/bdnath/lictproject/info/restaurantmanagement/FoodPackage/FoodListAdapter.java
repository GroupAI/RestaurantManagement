package bdnath.lictproject.info.restaurantmanagement.FoodPackage;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import bdnath.lictproject.info.restaurantmanagement.FoodDetailActivity;
import bdnath.lictproject.info.restaurantmanagement.MainActivity;
import bdnath.lictproject.info.restaurantmanagement.R;

public class FoodListAdapter extends RecyclerView.Adapter<FoodListAdapter.FoodViewHolder>  {
    private List<FoodClass> foodList;
    private Context context;
    private OnItemClickedListener listener;

    public interface OnItemClickedListener{
        void onItemClick(int position,FoodClass employee);
    }

    public void setOnItemClickedListener(OnItemClickedListener listener){
        this.listener=listener;
    }

    public FoodListAdapter(List<FoodClass>foodList,Context context) {
        this.context=context;
        this.foodList=foodList;
    }

    @NonNull
    @Override
    public FoodListAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.food_row_view, parent,false);
        return new FoodViewHolder(view,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodListAdapter.FoodViewHolder holder, final int position) {
        holder.itemName.setText(foodList.get(position).getFoodName());
        holder.price.setText(foodList.get(position).getFoodPrice());
        holder.itemType.setText(foodList.get(position).getFoodType());
        holder.detailBTN.setVisibility(View.GONE);

    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }


    public class FoodViewHolder extends RecyclerView.ViewHolder{
        TextView itemName;
        TextView price;
        TextView itemType;
        LinearLayout parentLayout;
        Button detailBTN;

        public FoodViewHolder(final View itemView, final OnItemClickedListener listener) {
            super(itemView);

            itemName=itemView.findViewById(R.id.itemName);
            price=itemView.findViewById(R.id.price);
            itemType=itemView.findViewById(R.id.itemType);
            parentLayout=itemView.findViewById(R.id.parentLayout);
            detailBTN=itemView.findViewById(R.id.detailBTN);

            /*detailBTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FoodClass employee = foodList.get(getItemCount());
                    listener.onItemClick(getItemCount(),employee);
                }
            });*/
        }
    }
}
