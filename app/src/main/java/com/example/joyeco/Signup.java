package com.example.joyeco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
EditText fullName,email,occupation,password,confirmPass;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        fullName = (EditText)findViewById(R.id.fullName);
        email = (EditText)findViewById(R.id.email);
        occupation = (EditText)findViewById(R.id.occupation);
        password = (EditText)findViewById(R.id.password);
        confirmPass = (EditText)findViewById(R.id.confirmPass);
        db = new DatabaseHelper(this);
    }

    public void Registered(View view) {
        String name = fullName.getText().toString(),
                emailT =email.getText().toString() ,
                occupationT = occupation.getText().toString(),
                passwordT =password.getText().toString() ,
                cPassT = confirmPass.getText().toString();
        boolean error = false;
        boolean checkUser = false;

        if(name.equals("")||name==null)
        {
            fullName.setError("Required field");
            error = true;
        }
        if(emailT.equals("")||emailT==null)
        {
            error = true;
            email.setError("Required field");
        }
        if(occupationT.equals("")||occupationT==null)
        {
            error = true;
            occupation.setError("Required field");
        }
        if(passwordT.equals("")||passwordT==null)
        {
            error = true;
            password.setError("Required field");
        }
        if(cPassT.equals("")||cPassT==null)
        {
            error = true;
            confirmPass.setError("Required field");
        }
        if(!passwordT.equals(cPassT))
        {
            error = true;
            confirmPass.setError("Password doesn't match");
        }

        if(error==false){
            checkUser = db.checkUsername(emailT);
            if(checkUser==false) {
                long val = db.addUser(emailT, passwordT);
                if (val > 0) {
                    Toast.makeText(Signup.this, "You have registered", Toast.LENGTH_SHORT).show();
                    Intent intent  = new Intent(Signup.this,Login.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(Signup.this, "Registeration Error", Toast.LENGTH_SHORT).show();
                    fullName.setText(null);
                    email.setText(null);
                    password.setText(null);
                    occupation.setText(null);
                }
            }
            else {
                Toast.makeText(Signup.this, "email already exist", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void LoginScreen(View view) {
        Intent intent  = new Intent(Signup.this,Login.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent  = new Intent(Signup.this,MainActivity.class);
        startActivity(intent);
    }
}