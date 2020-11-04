package com.example.joyeco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class splashscreen extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 2000;
    ImageView imageLogo;
    Animation topAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        if(preferenceUtils.get("token",this)!=null){
            Intent mainIntent = new Intent(splashscreen.this,HomeScreen.class);
            startActivity(mainIntent);
        }
        else {

        topAnim = AnimationUtils.loadAnimation(this,R.anim.fade);
        imageLogo = findViewById(R.id.splashscreen);
        imageLogo.setAnimation(topAnim);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                Intent mainIntent = new Intent(splashscreen.this,MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }}
}