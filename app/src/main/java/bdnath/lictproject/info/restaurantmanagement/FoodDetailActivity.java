package bdnath.lictproject.info.restaurantmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import bdnath.lictproject.info.restaurantmanagement.FoodPackage.FoodClass;
import bdnath.lictproject.info.restaurantmanagement.database.FoodDatabaseSource;

public class FoodDetailActivity extends AppCompatActivity {
    private TextView foodNameDetailTV;
    private TextView priceDetailTV;
    private TextView typeDetailTV;
    private TextView detailDetailTV;
    private FoodClass food;
    private FoodDatabaseSource source;
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        foodNameDetailTV=findViewById(R.id.foodNameDetailTV);
        priceDetailTV=findViewById(R.id.priceDetailTV);
        typeDetailTV=findViewById(R.id.typeDetailTV);
        detailDetailTV=findViewById(R.id.detailDetailTV);
        source=new FoodDatabaseSource(this);

        Intent intent=getIntent();
       index = intent.getIntExtra("msg",1);
       food= source.getFoodDetailById(index);

        if (food!=null){
            foodNameDetailTV.setText(food.getFoodName());
            priceDetailTV.setText(food.getFoodPrice());
            typeDetailTV.setText(food.getFoodType());
            detailDetailTV.setText(food.getFoodDetails());
            Toast.makeText(this,"ok",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"Some Problem",Toast.LENGTH_LONG).show();
        }


    }

    public void deleteBTN(View view) {
        if(source.deleteFoodItem(index)){
            Toast.makeText(this,"This item is deleted successfully",Toast.LENGTH_LONG).show();
            Intent intent =new Intent(FoodDetailActivity.this,FoodListActivity.class);
            startActivity(intent);
        }else {
            Toast.makeText(this,"This item not deleted!!",Toast.LENGTH_LONG).show();
        }

    }

    public void editBTN(View view) {
        Intent intent=new Intent(FoodDetailActivity.this,FoodItemAddActivity.class);
        intent.putExtra("msg",index);
        startActivity(intent);
    }
}
