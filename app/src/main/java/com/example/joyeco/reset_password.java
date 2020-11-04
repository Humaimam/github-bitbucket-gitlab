package com.example.joyeco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class reset_password extends AppCompatActivity {

    EditText email, newPassword, confirmPassword;
    DatabaseHelper db;
    String emailT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        email = (EditText)findViewById(R.id.email);
        newPassword = (EditText)findViewById(R.id.newPassword);
        confirmPassword = (EditText)findViewById(R.id.confirmPassword);
        db = new DatabaseHelper(this);
        emailT = getIntent().getStringExtra("email");
        email.setText(emailT);
    }

    public void reset(View view) {
        boolean error = false;
        String oldPass, newPass, conPass;
        newPass = newPassword.getText().toString();
        conPass = confirmPassword.getText().toString();

        if(newPass.equals("")||newPass==null)
        {
            error = true;
            newPassword.setError("Required field");
        }
        if(conPass.equals("")||conPass==null)
        {
            error = true;
            confirmPassword.setError("Required field");
        }
        if(!newPass.equals(conPass)){
            error = true;
            confirmPassword.setError("Password doesn't match");
        }

        if(error==false){
            if(db.checkUsername(email.getText().toString())){
                Toast.makeText(this,"Please register your account first",Toast.LENGTH_SHORT);
                if(db.checkUsername(email.getText().toString())){
                    if(db.updatePassword(email.getText().toString(),newPass)>0){
                        System.out.println("Updated");
                        Toast.makeText(this,"Updated",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        System.out.println("Something went wrong");
                        Toast.makeText(this,"Something went wrong",Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    System.out.println("Invalid password");
                    Toast.makeText(this,"Invalid password",Toast.LENGTH_SHORT).show();
                }
            }
            else {
                System.out.println("Please register your account first");
                Toast.makeText(this,"Please register your account first",Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void login(View view) {
        Intent intent  = new Intent(reset_password.this,Login.class);
        startActivity(intent);
    }
}