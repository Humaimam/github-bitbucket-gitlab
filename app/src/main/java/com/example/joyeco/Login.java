package com.example.joyeco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText email,loginPassword;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText)findViewById(R.id.email);
        loginPassword = (EditText)findViewById(R.id.loginPassword);
        db = new DatabaseHelper(this);
    }

    public void login(View view) {
        String emailT =email.getText().toString() ,
                passwordT = loginPassword.getText().toString();
        boolean error = false;

        if(emailT.equals("")||emailT==null)
        {
            error = true;
            email.setError("Required field");
        }
        if(passwordT.equals("")||passwordT==null)
        {
            error = true;
            loginPassword.setError("Required field");
        }
        if(error==false){
            if(db.checkUsername(emailT))
            {
                if(db.checkUser(emailT,passwordT)){
                preferenceUtils.save("true","token",this);
                Intent intent  = new Intent(Login.this,HomeScreen.class);
                startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Invalid pasword", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(Login.this, "Please register your account first", Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void SignupScreen(View view) {
        Intent intent  = new Intent(Login.this,Signup.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent  = new Intent(Login.this,MainActivity.class);
        startActivity(intent);
    }

    public void forgotPassword(View view) {
        Intent intent  = new Intent(Login.this,reset_password.class);
        intent.putExtra("email",email.getText().toString());
        startActivity(intent);
    }
}