package com.example.ashu.healthypie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

public class ManageDevicesActivity extends AppCompatActivity {

    CardView babyCardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_devices);

        babyCardView=findViewById(R.id.baby);
        babyCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(ManageDevicesActivity.this,BabyActivity.class);
                startActivity(i);
            }
        });
    }
     

}
