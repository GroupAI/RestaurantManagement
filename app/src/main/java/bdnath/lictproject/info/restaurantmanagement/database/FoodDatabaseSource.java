package bdnath.lictproject.info.restaurantmanagement.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import bdnath.lictproject.info.restaurantmanagement.FoodClass;

public class FoodDatabaseSource {
    private FoodDatabaseHelper helper;
    private SQLiteDatabase db;

    public FoodDatabaseSource(Context context) {
        helper = new FoodDatabaseHelper(context);
    }

    public void open(){
        db = helper.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public boolean insertFood(FoodClass food){
        this.open();
        ContentValues values = new ContentValues();
        values.put(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_NAME, food.getFoodName());
        values.put(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_TYPE, food.getFoodType());
        values.put(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_PRICE, food.getFoodPrice());
        values.put(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_IMGPATH, food.getImagePath());
        values.put(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_DETAILS, food.getFoodDetails());

        long insertedRow = db.insert(FoodDatabaseHelper.TABLE_FOOD,null, values);
        this.close();
        if (insertedRow > 0){
            return true;
        }else {
            return false;
        }
    }

    public List<FoodClass> getAllFoods(){
        this.open();
        List<FoodClass>foods=new ArrayList<>();

        Cursor c = db.query(FoodDatabaseHelper.TABLE_FOOD, null, null,null,null, null,null);
        if (c!=null && c.getCount()>0){
            c.moveToFirst();

            do {
                int id =c.getInt(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_ID));
                String foodName = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_NAME));
                String foodType = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_TYPE));
                String foodPrice = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_PRICE));
                String foodImgPath = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_IMGPATH));
                String foodDetails = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_DETAILS));

                FoodClass food = new FoodClass(id, foodName, foodType, foodPrice, foodDetails, foodImgPath);
                foods.add(food);
            }while (c.moveToNext());
        }
        c.close();

        this.close();
        return foods;
    }
}
