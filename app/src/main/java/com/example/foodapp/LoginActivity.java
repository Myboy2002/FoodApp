package com.example.foodapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.foodapp.model.User;
import com.example.foodapp.model.UserDao;
import com.example.foodapp.model.UserDatabaseClass;

public class LoginActivity extends AppCompatActivity {

    Button btLogin,btSignup;
    EditText email,pass;
    private UserDatabaseClass userDatabaseClass;
    public UserDao userDao;

    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /*getSupportActionBar().hide();*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        userDatabaseClass = Room.databaseBuilder(this,UserDatabaseClass.class,"UserDb").allowMainThreadQueries().build();

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Check User...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setProgress(0);

        userDao = userDatabaseClass.getUserDao();
        email = findViewById(R.id.email_input);
        pass = findViewById(R.id.pass_input);
        btLogin = findViewById(R.id.login_btn);
        btSignup = findViewById(R.id.signup_btn);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!emptyValidation()){
                    progressDialog.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            User user = userDao.getUser(email.getText().toString(),pass.getText().toString());
                            if(user != null){
                                /*Sang trang*/
                                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                                intent.putExtra("user_name", user.getName());
                                startActivity(intent);
                                finish();
                            }
                            else {
                                Toast.makeText(LoginActivity.this, "Unregistered user, or incorrect", Toast.LENGTH_SHORT).show();
                            }
                            progressDialog.dismiss();
                        }
                    }, 1000);
                }else {
                    Toast.makeText(LoginActivity.this, "Empty Fields", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
    }
    private boolean emptyValidation() {
        if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(pass.getText().toString())) {
            return true;
        }else {
            return false;
        }
    }
}