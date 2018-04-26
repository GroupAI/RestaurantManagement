package bdnath.lictproject.info.restaurantmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bdnath.lictproject.info.restaurantmanagement.FoodPackage.FoodClass;
import bdnath.lictproject.info.restaurantmanagement.FoodPackage.FoodListAdapter;
import bdnath.lictproject.info.restaurantmanagement.FoodPackage.ListViewAdapter;
import bdnath.lictproject.info.restaurantmanagement.Preference.LoginPreferences;
import bdnath.lictproject.info.restaurantmanagement.database.FoodDatabaseSource;

public class FoodListActivity extends AppCompatActivity {

    private ListViewAdapter ListAdapter;
    private List<FoodClass> foodList=new ArrayList<>();
    private FoodDatabaseSource source;

    private ListView foodLV;
    private TextView warningText;
    private FoodListAdapter adapter;
    private LoginPreferences loginPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        loginPreferences = new LoginPreferences(this);

        foodLV=findViewById(R.id.foodLV);

        warningText=findViewById(R.id.warning);
        source=new FoodDatabaseSource(this);

        foodList=source.getAllFoods();
        if (foodList.size()==0){
            warningText.setText("No data founded!!!");
        }else{
            ListAdapter=new ListViewAdapter(this,foodList);
            foodLV.setAdapter(ListAdapter);
        }
    }

/*    public void addItem(View view) {
        Intent intent = new Intent(FoodListActivity.this,FoodItemAddActivity.class);
        startActivity(intent);
    }*/

    public void categoryView(View view) {
        Intent intent= new Intent(FoodListActivity.this,MainActivity.class);
        startActivity(intent);
    }
    ///////////////////////Menu Option
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_add:
                startActivity(new Intent(FoodListActivity.this,FoodItemAddActivity.class));
                break;
            case R.id.item_logout:
                loginPreferences.setStatus(false);
                startActivity(new Intent(FoodListActivity.this,AdminLoginActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
