package com.example.listeners;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Intent si, gi;
    Button blue_btn, red_btn, results_btn;
    int blue_counter, red_counter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gi = getIntent();
        si = new Intent(this, Results_activity.class);

        blue_btn = findViewById(R.id.Blue_btn);
        red_btn = findViewById(R.id.Red_btn);
        results_btn = findViewById(R.id.Results_btn);

        blue_counter = 0;
        red_counter = 0;


        blue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blue_counter++;
            }
        });

        red_btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                red_counter += 2;
                return false;
            }
        });

        results_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                si.putExtra("blue_result",blue_counter);
                si.putExtra("red_result",red_counter);
                startActivity(si);
                red_counter = 0;
                blue_counter = 0;
            }
        });
    }
}