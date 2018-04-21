package bdnath.lictproject.info.restaurantmanagement;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class HeveFragment extends Fragment {


    public HeveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toast.makeText(getContext(),"Heve Food Fragment Created",Toast.LENGTH_LONG).show();
        return inflater.inflate(R.layout.fragment_heve, container, false);
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

}
