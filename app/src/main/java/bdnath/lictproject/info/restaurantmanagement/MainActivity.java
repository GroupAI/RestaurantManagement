package bdnath.lictproject.info.restaurantmanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button goodBye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        goodBye=findViewById(R.id.goodBye);
    }

    public void goodBye(View view) {
        tv.setVisibility(View.INVISIBLE);
    }
}
