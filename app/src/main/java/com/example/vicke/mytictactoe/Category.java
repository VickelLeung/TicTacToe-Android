package com.example.vicke.mytictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Category extends AppCompatActivity {

    private Button btnMenu, btnPlayer, btnComputer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        btnMenu = (Button) findViewById(R.id.btnMenuCat);
        btnPlayer = (Button) findViewById(R.id.btnVsPlayer);
        btnComputer = (Button) findViewById(R.id.btnVsComputer);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goMenu = new Intent(Category.this, MainActivity.class);
                startActivity(goMenu);
            }
        });


        btnComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent goComputer = new Intent(Category.this, ComputerGame.class);
//                startActivity(goComputer);

                Intent goComputer = new Intent(Category.this, rollTheDice.class);
                startActivity(goComputer);

            }
        });

        btnPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            Intent goPlayer = new Intent(Category.this, PlayerGame.class);
            startActivity(goPlayer);

            }
        });

    }
}
