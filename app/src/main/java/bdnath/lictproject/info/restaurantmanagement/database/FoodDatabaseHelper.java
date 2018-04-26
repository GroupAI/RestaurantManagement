package bdnath.lictproject.info.restaurantmanagement.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FoodDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "food_db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_FOOD = "tbl_food";
    public static final String TABLE_FOOD_COL_ID = "_id";
    public static final String TABLE_FOOD_COL_FOOD_NAME= "food_name";
    public static final String TABLE_FOOD_COL_FOOD_TYPE= "food_type";
    public static final String TABLE_FOOD_COL_FOOD_PRICE= "food_price";
   // public static final String TABLE_FOOD_COL_FOOD_IMGPATH= "food_img_path";
    public static final String TABLE_FOOD_COL_FOOD_DETAILS= "food_details";

    public static final String CREATE_TABLE_FOOD = "create table "+ TABLE_FOOD + "(" +
            TABLE_FOOD_COL_ID + " integer primary key, " +
            TABLE_FOOD_COL_FOOD_NAME + " text, " +
            TABLE_FOOD_COL_FOOD_TYPE + " text, " +
            TABLE_FOOD_COL_FOOD_PRICE + " text, " +
            TABLE_FOOD_COL_FOOD_DETAILS + " text);";


    public FoodDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_FOOD);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
