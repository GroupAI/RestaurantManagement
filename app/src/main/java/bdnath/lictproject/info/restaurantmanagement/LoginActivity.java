package bdnath.lictproject.info.restaurantmanagement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText userNameET;
    private EditText passwordET;
    private LoginActivity loginActivity;
    private static final String ADMIN_EMAIL = "admin_email";
    private static final String ADMIN_PASSWORD = "admin_password";
    private static final String DEFAULT_MESSAGE = "User not found";
    private static final String ISLOGGEDIN = "isLoggedIn";


    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public LoginActivity(Context context) {
        sharedPreferences = context.getSharedPreferences("user",Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        userNameET=findViewById(R.id.userNameET);
        passwordET=findViewById(R.id.passwordET);
    }


    public void Login(View view) {

        String userName= String.valueOf(userNameET.getText());
        String password=String.valueOf(passwordET.getText());

        if(userName.equals(loginActivity.getAdminEmail()) && ADMIN_PASSWORD.equals(loginActivity.getAdminPassword())){
            loginActivity.setStatus(true);
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }else{
            Toast.makeText(this, "invalid email or password", Toast.LENGTH_SHORT).show();
        }

        }

    public void Registration(View view) {
        registerAdmin(ADMIN_EMAIL, ADMIN_PASSWORD);
        Intent intent =new Intent(LoginActivity.this,RegistrationActivity.class);
        startActivity(intent);
        registerAdmin(ADMIN_EMAIL, ADMIN_PASSWORD);

    }

    public String registerAdmin(String email, String pass){
        editor.putString(ADMIN_EMAIL,email);
        editor.putString(ADMIN_PASSWORD,pass);
        editor.commit();

        return "Registered Successfully";
    }
    public void setStatus(boolean status){
        editor.putBoolean(ISLOGGEDIN,status);
        editor.commit();
    }
    public static boolean getStatus(){
        return sharedPreferences.getBoolean(ISLOGGEDIN,false);
    }


    public static String getAdminEmail() {
        return sharedPreferences.getString(ADMIN_EMAIL,DEFAULT_MESSAGE);
    }

    public String getAdminPassword() {
        return sharedPreferences.getString(ADMIN_PASSWORD,DEFAULT_MESSAGE);
    }






    /*
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
    }*/

}
