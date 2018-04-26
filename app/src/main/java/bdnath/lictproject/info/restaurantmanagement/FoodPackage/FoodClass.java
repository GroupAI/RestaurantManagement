package bdnath.lictproject.info.restaurantmanagement.FoodPackage;

import java.util.ArrayList;
import java.util.List;

public class FoodClass {
    private int index;
    private String foodName;
    private String foodType;
    private String foodPrice;
    private String foodDetails;

    public FoodClass(String foodName, String foodType, String foodPrice, String foodDetails) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.foodPrice = foodPrice;
        this.foodDetails = foodDetails;
    }

    public FoodClass(int index, String foodName, String foodType, String foodPrice, String foodDetails) {
        this.index = index;
        this.foodName = foodName;
        this.foodType = foodType;
        this.foodPrice = foodPrice;
        this.foodDetails = foodDetails;
    }

    public FoodClass() {
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

/*    public List<FoodClass>getFoodList(){
        List<FoodClass> foodList = new ArrayList<>();
        foodList.add(new FoodClass("Biriyani","Heve Food","150","Heve food"));
        foodList.add(new FoodClass("Khicuri","Heve Food","150","Heve food"));
        foodList.add(new FoodClass("Polaw","Heve Food","150","Heve food"));

        return foodList;
    }*/
}
