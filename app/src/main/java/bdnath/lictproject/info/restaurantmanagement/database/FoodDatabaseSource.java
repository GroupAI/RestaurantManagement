package bdnath.lictproject.info.restaurantmanagement.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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

    public boolean insertFood(Food food){
        this.open();
        Con
    }
}
