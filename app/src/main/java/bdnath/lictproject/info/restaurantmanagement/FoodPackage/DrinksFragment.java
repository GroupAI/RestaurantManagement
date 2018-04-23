package bdnath.lictproject.info.restaurantmanagement.FoodPackage;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import bdnath.lictproject.info.restaurantmanagement.FoodClass;
import bdnath.lictproject.info.restaurantmanagement.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class DrinksFragment extends Fragment {

    private FoodClass food=new FoodClass();
    private FoodListAdapter foodAdapter;
    private RecyclerView drinksRecyclerView;


    public DrinksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toast.makeText(getContext(),"Drinks Fragment Created",Toast.LENGTH_LONG).show();
        View rootView=inflater.inflate(R.layout.fragment_drinks, container, false);
        drinksRecyclerView=rootView.findViewById(R.id.drinksRecycleView);
        foodAdapter=new FoodListAdapter(food.getFoodList());

        LinearLayoutManager llm=new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        drinksRecyclerView.setLayoutManager(llm);
        drinksRecyclerView.setAdapter(foodAdapter);

        return rootView;
    }
    @Override
    public void onPause() {
        Toast.makeText(getContext(),"Drinks Fragment Pause",Toast.LENGTH_LONG).show();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getContext(),"Drinks Fragment Destroy",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
    public void onAttach(Context context) {
        super.onAttach(context);
        Toast.makeText(getContext(),"Drinks Fragment onAttach",Toast.LENGTH_LONG).show();
    }

}
