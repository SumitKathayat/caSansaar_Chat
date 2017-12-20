package com.nextstyle.ICAI.casansaar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {
    private int Splash_Time=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(HomeActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        },Splash_Time);
    }
}
