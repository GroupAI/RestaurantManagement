package bdnath.lictproject.info.restaurantmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import bdnath.lictproject.info.restaurantmanagement.FoodPackage.FoodClass;
import bdnath.lictproject.info.restaurantmanagement.database.FoodDatabaseSource;

public class FoodItemAddActivity extends AppCompatActivity {
    private EditText foodNameET;
    private EditText priceET;
    private RadioGroup radioGroup;
    private EditText detailET;
    private Button loginBTN;

    private String foodName;
    private String foodPrice;
    private String foodType;
    private String foodDetails;
    private int index;


    private FoodDatabaseSource source=new FoodDatabaseSource(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item_add);

        foodNameET=findViewById(R.id.foodNameET);
        priceET=findViewById(R.id.priceET);
        radioGroup=findViewById(R.id.radioGroup);
        detailET=findViewById(R.id.detailET);
        loginBTN=findViewById(R.id.loginBTN);

        Intent intent=getIntent();
        index=intent.getIntExtra("msg",0);
        if (index>0){
            FoodClass foodClass=source.getFoodDetailById(index);
            foodNameET.setText(foodClass.getFoodName());
            priceET.setText(foodClass.getFoodPrice());
            detailET.setText(foodClass.getFoodDetails());
            if((foodClass.getFoodType().equals("Heve"))){
                ((RadioButton)findViewById(R.id.heve)).setChecked(true);
            }
            if((foodClass.getFoodType().equals("Snacks"))){
                ((RadioButton)findViewById(R.id.snack)).setChecked(true);
            }
            if((foodClass.getFoodType().equals("Desseret"))){
                ((RadioButton)findViewById(R.id.dessert)).setChecked(true);
            }
            if((foodClass.getFoodType().equals("Drink"))){
                ((RadioButton)findViewById(R.id.drink)).setChecked(true);
            }
            loginBTN.setText("Update");
        }else {
            ((RadioButton)findViewById(R.id.heve)).setChecked(true);
        }


        RadioButton rb=findViewById(R.id.heve);
        foodType=rb.getText().toString();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb=findViewById(checkedId);
                foodType=rb.getText().toString();
                Toast.makeText(FoodItemAddActivity.this,foodType,Toast.LENGTH_LONG).show();
            }
        });

    }

    public void cancleBatton(View view) {
        Toast.makeText(FoodItemAddActivity.this,"Data inserted",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(FoodItemAddActivity.this,FoodListActivity.class);
        startActivity(intent);
    }


    public void upBotton(View view) {
        if (index>0){
            foodName=foodNameET.getText().toString();
            foodPrice=priceET.getText().toString();
            foodDetails=detailET.getText().toString();

            if (foodName.isEmpty()){
                foodNameET.setError("Please fill your new food name.");
                return;
            }
            if (foodPrice.isEmpty()){
                priceET.setError("Please fill your new food price.");
                return;
            }
            if (foodDetails.isEmpty()){
                detailET.setError("Please fill your new food detail.");
                return;
            }
            if (foodType.isEmpty()){
                Toast.makeText(FoodItemAddActivity.this,"Please select your new food catagory",Toast.LENGTH_SHORT).show();
                return;
            }

            FoodClass food=new FoodClass(index,foodName,foodType,foodPrice,foodDetails);
            boolean status=source.updateFood(food);

            if (status){
                Toast.makeText(FoodItemAddActivity.this,"Item information successfully updated.",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(FoodItemAddActivity.this,FoodListActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(FoodItemAddActivity.this,"Item information not updated!!",Toast.LENGTH_SHORT).show();
            }
        }else {
            foodName=foodNameET.getText().toString();
            foodPrice=priceET.getText().toString();
            foodDetails=detailET.getText().toString();
            if (foodName.isEmpty()){
                foodNameET.setError("Please fill your new food name.");
                return;
            }
            if (foodPrice.isEmpty()){
                priceET.setError("Please fill your new food price.");
                return;
            }
            if (foodDetails.isEmpty()){
                detailET.setError("Please fill your new food detail.");
                return;
            }
            if (foodType.isEmpty()){
                Toast.makeText(FoodItemAddActivity.this,"Please select your new food catagory",Toast.LENGTH_SHORT).show();
                return;
            }

            FoodClass food=new FoodClass(foodName,foodType,foodPrice,foodDetails);
            boolean status=source.insertFood(food);
            if (status==true){
                Toast.makeText(FoodItemAddActivity.this,"Data inserted",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(FoodItemAddActivity.this,FoodListActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(FoodItemAddActivity.this,"Data not inserted",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
