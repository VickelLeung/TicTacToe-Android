package com.example.vicke.mytictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class howTo extends AppCompatActivity {

   private Button btnMenu, btnQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to);

        btnMenu = (Button) findViewById(R.id.btnMenuCat);


        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent goMenu = new Intent(howTo.this, MainActivity.class);
                startActivity(goMenu);

            }
        });

    }
}
