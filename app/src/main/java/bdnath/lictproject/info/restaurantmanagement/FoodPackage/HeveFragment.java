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

import bdnath.lictproject.info.restaurantmanagement.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeveFragment extends Fragment {
    private FoodClass food=new FoodClass();
    private FoodListAdapter foodListAdapter;
    private RecyclerView heveRecycleView;


    public HeveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toast.makeText(getContext(),"Heve Food Fragment Created",Toast.LENGTH_LONG).show();

        View rootView =inflater.inflate(R.layout.fragment_heve, container, false);
        heveRecycleView=rootView.findViewById(R.id.hevesRecycleView);
        foodListAdapter=new FoodListAdapter(food.getFoodList());

        LinearLayoutManager llm=new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        heveRecycleView.setLayoutManager(llm);
        heveRecycleView.setAdapter(foodListAdapter);

        return rootView;
    }
    @Override
    public void onPause() {
        Toast.makeText(getContext(),"Heve Food Fragment Pause",Toast.LENGTH_LONG).show();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getContext(),"Heve Food Fragment Destroy",Toast.LENGTH_LONG).show();
        super.onDestroy();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Toast.makeText(getContext(),"Heve Food Fragment onAttach",Toast.LENGTH_LONG).show();
    }

}
