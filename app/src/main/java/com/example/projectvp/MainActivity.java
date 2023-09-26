package com.example.projectvp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView buslistCardView,findbusCardView,convertoneyCardView,historicalPlaceCardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buslistCardView=findViewById(R.id.idbuslist);
        findbusCardView=findViewById(R.id.idfindbus);
        convertoneyCardView=findViewById(R.id.idconvertmoney);
        historicalPlaceCardView=findViewById(R.id.idplace);

        buslistCardView.setOnClickListener(this);
        findbusCardView.setOnClickListener(this);
        convertoneyCardView.setOnClickListener(this);
        historicalPlaceCardView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId()==R.id.idbuslist)
        {
            Intent intent=new Intent(MainActivity.this,BusList.class);
            startActivity(intent);
        }

        if(v.getId()==R.id.idfindbus)
        {
            Intent intent=new Intent(MainActivity.this,FindBus.class);
            startActivity(intent);
        }

        if(v.getId()==R.id.idconvertmoney)
        {
            Intent intent=new Intent(MainActivity.this,ConveMoney.class);
            startActivity(intent);
        }

        if(v.getId()==R.id.idplace)
        {
            Intent intent=new Intent(MainActivity.this,Place.class);
            startActivity(intent);
        }


    }
}