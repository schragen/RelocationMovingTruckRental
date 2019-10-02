package com.example.relocationmovingtruckrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Cost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cost);
        TextView total = (TextView)findViewById(R.id.txtTotal);
        ImageView image = (ImageView) findViewById(R.id.imgTruck);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int intSize = sharedPref.getInt("key1", 0);
        int intMiles = sharedPref.getInt("key2", 0);
        double totalCost;

        DecimalFormat currency = new DecimalFormat("$###,###.##");
        if (intSize == 10) {
            totalCost = intMiles * 19.95;
            total.setText("Total cost for rental is " + currency.format(totalCost));
            image.setImageResource(R.drawable.ten);
        }
        else if (intSize == 17) {
            totalCost = intMiles * 29.95;
            total.setText("Total cost for rental is " + currency.format(totalCost));
            image.setImageResource(R.drawable.seventeen);
        }
        else if (intSize == 26) {
            totalCost = intMiles * 39.95;
            total.setText("Total cost for rental is " + currency.format(totalCost));
            image.setImageResource(R.drawable.twentysix);
        }
        else {
            total.setText("Enter 10, 17 or 26 for Truck Size");
        }
    }
}
