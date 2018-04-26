package bdnath.lictproject.info.restaurantmanagement.FoodPackage;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
public class SnacksFragment extends Fragment {

    private FoodClass food=new FoodClass();
    private FoodListAdapter foodListAdapter;
    private List<FoodClass> foodList=new ArrayList<>();
    private FoodDatabaseSource source;
    private TextView warningText;
    private RecyclerView snacksRecycleView;

    public SnacksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //Toast.makeText(getContext(),"Snacks Fragment Created",Toast.LENGTH_LONG).show();


        View rootView=inflater.inflate(R.layout.fragment_snacks, container, false);
        snacksRecycleView= rootView.findViewById(R.id.snacksRecycleView);
        //foodListAdapter=new FoodListAdapter(food.getFoodList());

        warningText=rootView.findViewById(R.id.warning);
        source=new FoodDatabaseSource(getContext());
        foodList=source.getSelectedTypeFoods("Snacks");
        if (foodList.size()==0){
            warningText.setText("No data founded!!!");
        }else{
            foodListAdapter=new FoodListAdapter(foodList,getContext());
            LinearLayoutManager llm = new LinearLayoutManager(getContext());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            snacksRecycleView.setLayoutManager(llm);
            snacksRecycleView.setAdapter(foodListAdapter);

            /*foodListAdapter.setOnItemClickedListener(new FoodListAdapter.OnItemClickedListener() {
                @Override
                public void onItemClick(int position) {
                    String st=foodList.get(position).getFoodName();
                    Toast.makeText(getContext(),st,Toast.LENGTH_LONG).show();
                }
            });*/
        }



        return rootView;
    }


    @Override
    public void onPause() {
        //Toast.makeText(getContext(),"Snacks Fragment Pause",Toast.LENGTH_LONG).show();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        //Toast.makeText(getContext(),"Snacks Fragment Destroy",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //Toast.makeText(getContext(),"Snacks Fragment onAttach",Toast.LENGTH_LONG).show();
    }
}
