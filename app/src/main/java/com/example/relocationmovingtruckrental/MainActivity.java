package com.example.relocationmovingtruckrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int intSize;
    int intMiles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText size = (EditText)findViewById(R.id.txtSize);
        final EditText miles = (EditText)findViewById(R.id.txtMiles);
        Button button = (Button)findViewById(R.id.btnCalculate);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intSize = Integer.parseInt(size.getText().toString());
                intMiles = Integer.parseInt(miles.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", intSize);
                editor.putInt("key2", intMiles);
                editor.commit();
                startActivity(new Intent(MainActivity.this, Cost.class));
            }
        });
    }
}
