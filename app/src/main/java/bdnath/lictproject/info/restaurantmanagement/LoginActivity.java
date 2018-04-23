package bdnath.lictproject.info.restaurantmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText userNameET;
    private EditText passwordET;
    private String userName;
    private String password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userNameET=findViewById(R.id.userNameET);
        passwordET=findViewById(R.id.passwordET);
    }

    public void Registration(View view) {
        Intent intent =new Intent(LoginActivity.this,RegistrationActivity.class);
        startActivity(intent);
    }

    public void Login(View view) {

        userName= String.valueOf(userNameET.getText());
        password=String.valueOf(passwordET.getText());

        if (userName.equals("admin")&&password.equals("admin")){
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }
}
