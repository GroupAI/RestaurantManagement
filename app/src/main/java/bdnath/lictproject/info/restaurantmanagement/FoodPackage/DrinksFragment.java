package bdnath.lictproject.info.restaurantmanagement.FoodPackage;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bdnath.lictproject.info.restaurantmanagement.R;
import bdnath.lictproject.info.restaurantmanagement.database.FoodDatabaseSource;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrinksFragment extends Fragment {

    private FoodClass food=new FoodClass();
    private FoodListAdapter foodListAdapter;
    private List<FoodClass> foodList=new ArrayList<>();
    private FoodDatabaseSource source;

    private TextView warningText;
    private RecyclerView drinksRecyclerView;


    public DrinksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Toast.makeText(getContext(),"Drinks Fragment Created",Toast.LENGTH_LONG).show();
        View rootView=inflater.inflate(R.layout.fragment_drinks, container, false);

        drinksRecyclerView=rootView.findViewById(R.id.drinksRecycleView);

        warningText=rootView.findViewById(R.id.warning);
        source=new FoodDatabaseSource(getContext());

        foodList=source.getSelectedTypeFoods("Drink");
        if (foodList.size()==0){
            warningText.setText("No data founded!!!");
        }else{
            foodListAdapter=new FoodListAdapter(foodList,getContext());
            LinearLayoutManager llm=new LinearLayoutManager(getContext());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            drinksRecyclerView.setLayoutManager(llm);
            drinksRecyclerView.setAdapter(foodListAdapter);
        }

        return rootView;
    }
    @Override
    public void onPause() {
        //Toast.makeText(getContext(),"Drinks Fragment Pause",Toast.LENGTH_LONG).show();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        //Toast.makeText(getContext(),"Drinks Fragment Destroy",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
    public void onAttach(Context context) {
        super.onAttach(context);
        //Toast.makeText(getContext(),"Drinks Fragment onAttach",Toast.LENGTH_LONG).show();
    }

}
