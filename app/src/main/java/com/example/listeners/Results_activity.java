package com.example.listeners;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Results_activity extends AppCompatActivity {
    Intent gi;
    TextView blue_player, red_player, winner;
    int blue_result, red_result;
    Button return_btn;
    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        return_btn = findViewById(R.id.return_btn);
        gi = getIntent();

        blue_player = findViewById(R.id.Blue_player);
        red_player = findViewById(R.id.Red_player);
        winner = findViewById(R.id.Winner);

        blue_result = gi.getIntExtra("blue_result", -1);
        red_result = gi.getIntExtra("red_result", -1);

        blue_player.setText(blue_player.getText() + "" + blue_result);
        red_player.setText(red_player.getText() + "" + red_result);


        if (blue_result > red_result){
            winner.setText(winner.getText() + "blue");
        }
        else if(red_result > blue_result){
            winner.setText(winner.getText() + "red");
        }
        else{
            winner.setText(winner.getText() + "Tie");
        }
        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}