package com.example.vicke.mytictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnPlay;
    Button btnHowTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnHowTo = (Button) findViewById(R.id.btnHowTo);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent goCategory = new Intent(MainActivity.this, Category.class);
            startActivity(goCategory);


            }
        });

        btnHowTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent goHow = new Intent(MainActivity.this, howTo.class);
                startActivity(goHow);
            }
        });


    }
}
