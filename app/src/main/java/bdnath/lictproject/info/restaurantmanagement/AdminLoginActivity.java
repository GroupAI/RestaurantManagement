package bdnath.lictproject.info.restaurantmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import bdnath.lictproject.info.restaurantmanagement.Preference.LoginPreferences;

public class AdminLoginActivity extends AppCompatActivity {

    private EditText emailET, passET;
    private LoginPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);
        emailET = findViewById(R.id.adminEmail);
        passET = findViewById(R.id.adminPassword);
        preferences = new LoginPreferences(this);

        if (preferences.getStatus()){
            startActivity(new Intent(AdminLoginActivity.this,FoodListActivity.class));
            Toast.makeText(this, "Already Logged!!", Toast.LENGTH_SHORT).show();
        }

    }

    public void loginAdmin(View view) {
        String email = emailET.getText().toString();
        String pass = passET.getText().toString();
        if (email.isEmpty()){
            emailET.setError("Please enter your email");
            return;
        }
        if (pass.isEmpty()){
            passET.setError("Please enter your email");
            return;
        }
        if(email.equals(preferences.getAdminEmail()) && pass.equals(preferences.getAdminPassword())){
            preferences.setStatus(true);
            startActivity(new Intent(AdminLoginActivity.this,FoodListActivity.class));
        }else{
            Toast.makeText(this, "invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }

    public void registerAdmin(View view) {
        String email = emailET.getText().toString();
        String pass = passET.getText().toString();
        if (email.isEmpty()){
            emailET.setError("Please enter your email");
            return;
        }
        if (pass.isEmpty()){
            passET.setError("Please enter your email");
            return;
        }
        String msg = preferences.registerAdmin(email,pass);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(AdminLoginActivity.this,FoodListActivity.class));
    }
}
