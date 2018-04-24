package bdnath.lictproject.info.restaurantmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void doneBotton(View view) {

        startActivity(new Intent(RegistrationActivity.this,MainActivity.class));
    }

    public void cancleBatton(View view) {
    }
}
