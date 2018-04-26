package bdnath.lictproject.info.restaurantmanagement.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import bdnath.lictproject.info.restaurantmanagement.FoodPackage.FoodClass;

public class FoodDatabaseSource {
    private FoodDatabaseHelper helper;
    private SQLiteDatabase db;
    public static final String TAG="Data Base> ";

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
       // values.put(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_IMGPATH, food.getImagePath());
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
                int inedx =c.getInt(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_ID));
                String foodName = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_NAME));
                String foodType = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_TYPE));
                String foodPrice = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_PRICE));
                //String foodImgPath = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_IMGPATH));
                String foodDetails = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_DETAILS));
                FoodClass food = new FoodClass(inedx,foodName,foodType,foodPrice,foodDetails);
                foods.add(food);
            }while (c.moveToNext());
        }
        c.close();

        this.close();
        return foods;
    }

    public List<FoodClass> getSelectedTypeFoods(String type){
        this.open();
        List<FoodClass>foods=new ArrayList<>();

        //Cursor c = db.query(FoodDatabaseHelper.TABLE_FOOD, null, null,null,null, FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_TYPE+" = "+type,null);
        Cursor c=db.rawQuery("SELECT * FROM "+FoodDatabaseHelper.TABLE_FOOD+" WHERE "+FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_TYPE+" = '"+type+"'",null);
        if (c!=null && c.getCount()>0){
            c.moveToFirst();

            do {
                int inedx =c.getInt(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_ID));
                String foodName = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_NAME));
                String foodType = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_TYPE));
                String foodPrice = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_PRICE));
                String foodDetails = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_DETAILS));
                FoodClass food = new FoodClass(inedx,foodName,foodType,foodPrice,foodDetails);
                foods.add(food);
            }while (c.moveToNext());
        }
        c.close();

        this.close();
        return foods;
    }

    public FoodClass getFoodDetailById(int rowId){
        this.open();
        FoodClass food = null;
        Cursor c = db.query(FoodDatabaseHelper.TABLE_FOOD,null,FoodDatabaseHelper.TABLE_FOOD_COL_ID+" = "+rowId,null,null,null,null);
        if(c != null && c.getCount() > 0){
            c.moveToFirst();
            int inedx =c.getInt(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_ID));
            String foodName = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_NAME));
            String foodType = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_TYPE));
            String foodPrice = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_PRICE));
            String foodDetails = c.getString(c.getColumnIndex(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_DETAILS));

            food = new FoodClass(inedx,foodName,foodType,foodPrice,foodDetails);
        }
        c.close();
        this.close();
        return food;
    }

    public boolean deleteFoodItem(int empId){
        this.open();
        int deletedRow = db.delete(FoodDatabaseHelper.TABLE_FOOD,FoodDatabaseHelper.TABLE_FOOD_COL_ID+" = "+empId,null);
        this.close();
        if(deletedRow > 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean updateFood(FoodClass foodClass){
        this.open();
        Log.d(TAG, "updateFood: "+foodClass.getIndex());
        Log.d(TAG, "updateFood: "+foodClass.getFoodName());
        Log.d(TAG, "updateFood: "+foodClass.getFoodType());
        Log.d(TAG, "updateFood: "+foodClass.getFoodPrice());
        Log.d(TAG, "updateFood: "+foodClass.getFoodDetails());
        ContentValues values = new ContentValues();
        values.put(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_NAME,foodClass.getFoodName());
        values.put(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_TYPE,foodClass.getFoodType());
        values.put(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_PRICE,foodClass.getFoodPrice());
        values.put(FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_DETAILS,foodClass.getFoodDetails());
        int updatedRow = db.update(FoodDatabaseHelper.TABLE_FOOD,values,FoodDatabaseHelper.TABLE_FOOD_COL_ID+" = '"+foodClass.getIndex()+"'",null);

      /* String query="UPDATE "+FoodDatabaseHelper.DATABASE_NAME+" SET " +
               FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_NAME+" = '"+foodClass.getFoodName()+"', "+
               FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_TYPE+" = '"+foodClass.getFoodType()+"', "+
               FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_PRICE+" = '"+foodClass.getFoodPrice()+"', "+
               FoodDatabaseHelper.TABLE_FOOD_COL_FOOD_DETAILS+" = '"+foodClass.getFoodDetails()+"' "+
               "WHERE " +FoodDatabaseHelper.TABLE_FOOD_COL_ID+" = '"+foodClass.getIndex()+"'";
        db.rawQuery(query,null);
        this.close();
        return true;*/

        this.close();
       if(updatedRow > 0){
            return true;
        }else{
            return false;
        }
    }

}
