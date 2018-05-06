package com.example.vicke.mytictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class rollTheDice extends AppCompatActivity {

    private ImageView diceImg;
    private Button rollTheDice;
    private int randomNumber;
    private AlertDialog.Builder builder;
    private int numberRolled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_the_dice);

        builder = new AlertDialog.Builder(this);
//        builder.setCancelable(false);

        diceImg = findViewById(R.id.playerDice);
        rollTheDice = findViewById(R.id.rollDice);

        //onclick roll dice, roll the dice and set image

        rollTheDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //generate a random number
                randomNumber = rollDices();

                //roll the dice
                setDiceImg(randomNumber);

                if(numberRolled % 2 == 0)
                    builder.setTitle("Player play first");
                else if(numberRolled % 2 == 1)
                    builder.setTitle("Computer play first!");

                builder.setMessage("The dice rolled a " + numberRolled);
                builder.setPositiveButton("Click to play Game!",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent playGame = new Intent(rollTheDice.this, ComputerGame.class);
                                playGame.putExtra("numberRolled", numberRolled);
                                startActivity(playGame);

                            }
                        });

               final AlertDialog dialog = builder.create();

                dialog.setCanceledOnTouchOutside(false);
                dialog.show();

//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    public void run() {
//                        dialog.dismiss();
//                    }
//                }, 150000);  // 1500 seconds


            }
        });

    }


    public int rollDices(){
       Random rand = new Random();
       int n = rand.nextInt(6)+1;

       //set number rolled
       numberRolled = n;

        return n;
    }

    public int getNumberRolled(){
       return numberRolled;
    }

    public void setDiceImg(int x){

        switch(x){

            case 1:
                diceImg.setImageResource(R.drawable.dice1);
                break;
            case 2:
                diceImg.setImageResource(R.drawable.dice2);
                break;
            case 3:
                diceImg.setImageResource(R.drawable.dice3);
                break;
            case 4:
                diceImg.setImageResource(R.drawable.dice4);
                break;
            case 5:
                diceImg.setImageResource(R.drawable.dice5);
                break;
            case 6:
                diceImg.setImageResource(R.drawable.dice6);
                break;
        }
    }

}
