package bdnath.lictproject.info.restaurantmanagement;

import java.util.ArrayList;
import java.util.List;

public class FoodClass {
    private int index;
    private String foodName;
    private String foodType;
    private String foodPrice;
    private String foodDetails;
    private String foodImagePath;

    public FoodClass() {
    }

    public String getImagePath() {
        return foodImagePath;
    }

    public FoodClass(int index, String foodName, String foodType, String foodPrice, String foodDetails, String foodImagePath) {
        this.index = index;
        this.foodName = foodName;
        this.foodType = foodType;
        this.foodPrice = foodPrice;
        this.foodDetails = foodDetails;
        this.foodImagePath=foodImagePath;

    }

    public FoodClass(String foodName, String foodType, String foodPrice, String foodDetails,String foodImagePath) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.foodPrice = foodPrice;
        this.foodDetails = foodDetails;
        this.foodImagePath=foodImagePath;
    }
    public FoodClass(String foodName, String foodType, String foodPrice, String foodDetails) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.foodPrice = foodPrice;
        this.foodDetails = foodDetails;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(String foodPrice) {
        this.foodPrice = foodPrice;
    }

    public String getFoodDetails() {
        return foodDetails;
    }

    public void setFoodDetails(String foodDetails) {
        this.foodDetails = foodDetails;
    }

    public List<FoodClass>getFoodList(){
        List<FoodClass> foodList = new ArrayList<>();
        foodList.add(new FoodClass("Biriyani","Heve Food","150","Heve food"));
        foodList.add(new FoodClass("Khicuri","Heve Food","150","Heve food"));
        foodList.add(new FoodClass("Polaw","Heve Food","150","Heve food"));

        return foodList;
    }
}
