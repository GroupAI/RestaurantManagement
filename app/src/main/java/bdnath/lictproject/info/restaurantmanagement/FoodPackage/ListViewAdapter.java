package bdnath.lictproject.info.restaurantmanagement.FoodPackage;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import bdnath.lictproject.info.restaurantmanagement.FoodDetailActivity;
import bdnath.lictproject.info.restaurantmanagement.R;

public class ListViewAdapter extends ArrayAdapter<FoodClass> {
    private Context context;
    private List<FoodClass> food;
    private int count=0;


    public ListViewAdapter(@NonNull Context context, List<FoodClass> food) {
        super(context, R.layout.food_row_view, food);
        this.food=food;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.food_row_view,parent,false);

        TextView itemName=convertView.findViewById(R.id.itemName);
        TextView price=convertView.findViewById(R.id.price);
        TextView itemType=convertView.findViewById(R.id.itemType);
        Button detailBTN=convertView.findViewById(R.id.detailBTN);

        itemName.setText(food.get(position).getFoodName());
        price.setText(food.get(position).getFoodPrice());
        itemType.setText(food.get(position).getFoodType());

        detailBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoodClass employee = food.get(position);
                Intent intent = new Intent(context,FoodDetailActivity.class);
                intent.putExtra("msg",employee.getIndex());
                context.startActivity(intent);
                Toast.makeText(context, "details", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }
}
