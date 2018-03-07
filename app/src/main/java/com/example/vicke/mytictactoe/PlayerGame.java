package com.example.vicke.mytictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerGame extends AppCompatActivity {

    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnRestart, btnMainMenu;
    private TextView p1Score, p2Score;
    private int[] grid;
    private int numberOfTurn, totalP1Score, totalP2Score;
    private int toggleWin = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_game);
        grid = new int[9];
        numberOfTurn = 1;
        totalP1Score = totalP2Score = 0;

        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEight = findViewById(R.id.btnEigth);

        btnRestart = findViewById(R.id.btnRestart);
        btnMainMenu = findViewById(R.id.btnMenuComp);

        p1Score = findViewById(R.id.p1Score);
        p2Score = findViewById(R.id.p2Score);

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if player has already won
                if(checkWin() == 0){

                    //first player
                    if (numberOfTurn % 2 == 1 && grid[0] == 0) {
                        btnZero.setText("X");
                        btnZero.setTextColor(getResources().getColor(R.color.colorPrimary));
                        grid[0] = 1;
                        numberOfTurn++;
                    }
                    //second player
                    else if(numberOfTurn%2 == 0 && grid[0] == 0){
                        btnZero.setText("O");
                        btnZero.setTextColor(getResources().getColor(R.color.red));
                        grid[0] = 2;
                        numberOfTurn++;

                    }
                }
                setScore();
                autoReset();
            }
        });


        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //check if player has already won
                if(checkWin() == 0){

                    //first player
                    if (numberOfTurn % 2 == 1 && grid[1] == 0) {
                        btnOne.setText("X");
                        btnOne.setTextColor(getResources().getColor(R.color.colorPrimary));
                        grid[1] = 1;
                        numberOfTurn++;
                    }
                    //second player
                    else if(numberOfTurn%2 == 0 && grid[1] == 0){
                        btnOne.setText("O");
                        btnOne.setTextColor(getResources().getColor(R.color.red));
                        grid[1] = 2;
                        numberOfTurn++;

                    }
                }
                setScore();
                autoReset();
            }
        });


        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if player has already won
                if(checkWin() == 0){

                    //first player
                    if (numberOfTurn % 2 == 1 && grid[2] == 0) {
                        btnTwo.setText("X");
                        btnTwo.setTextColor(getResources().getColor(R.color.colorPrimary));
                        grid[2] = 1;
                        numberOfTurn++;
                    }
                    //second player
                    else if(numberOfTurn%2 == 0 && grid[2] == 0){
                        btnTwo.setText("O");
                        btnTwo.setTextColor(getResources().getColor(R.color.red));
                        grid[2] = 2;
                        numberOfTurn++;
                    }
                }
                setScore();
                autoReset();
            }
        });


        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if player has already won
                if(checkWin() == 0){

                    //first player
                    if (numberOfTurn % 2 == 1 && grid[3] == 0) {
                        btnThree.setText("X");
                        btnThree.setTextColor(getResources().getColor(R.color.colorPrimary));
                        grid[3] = 1;
                        numberOfTurn++;
                    }
                    //second player
                    else if(numberOfTurn%2 == 0 && grid[3] == 0){
                        btnThree.setText("O");
                        btnThree.setTextColor(getResources().getColor(R.color.red));
                        grid[3] = 2;
                        numberOfTurn++;
                    }
                }
                setScore();
                autoReset();
            }
        });



        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if player has already won
                if(checkWin() == 0){

                    //first player
                    if (numberOfTurn % 2 == 1 && grid[4] == 0) {
                        btnFour.setText("X");
                        btnFour.setTextColor(getResources().getColor(R.color.colorPrimary));
                        grid[4] = 1;
                        numberOfTurn++;
                    }
                    //second player
                    else if(numberOfTurn%2 == 0 && grid[4] == 0){
                        btnFour.setText("O");
                        btnFour.setTextColor(getResources().getColor(R.color.red));
                        grid[4] = 2;
                        numberOfTurn++;
                    }
                }
                setScore();
                autoReset();

            }
        });


        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if player has already won
                if(checkWin() == 0){

                    //first player
                    if (numberOfTurn % 2 == 1 && grid[5] == 0) {
                        btnFive.setText("X");
                        btnFive.setTextColor(getResources().getColor(R.color.colorPrimary));
                        grid[5] = 1;
                        numberOfTurn++;
                    }
                    //second player
                    else if(numberOfTurn%2 == 0 && grid[5] == 0){
                        btnFive.setText("O");
                        btnFive.setTextColor(getResources().getColor(R.color.red));
                        grid[5] = 2;
                        numberOfTurn++;

                    }
                }
                setScore();
                autoReset();
            }
        });


        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if player has already won
                if(checkWin() == 0){

                    //first player
                    if (numberOfTurn % 2 == 1 && grid[6] == 0) {
                        btnSix.setText("X");
                        btnSix.setTextColor(getResources().getColor(R.color.colorPrimary));
                        grid[6] = 1;
                        numberOfTurn++;
                    }
                    //second player
                    else if(numberOfTurn%2 == 0 && grid[6] == 0){
                        btnSix.setText("O");
                        btnSix.setTextColor(getResources().getColor(R.color.red));
                        grid[6] = 2;
                        numberOfTurn++;
                    }
                }
                setScore();
                autoReset();
            }
        });


        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if player has already won
                if(checkWin() == 0){

                    //first player
                    if (numberOfTurn % 2 == 1 && grid[7] == 0) {
                        btnSeven.setText("X");
                        btnSeven.setTextColor(getResources().getColor(R.color.colorPrimary));
                        grid[7] = 1;
                        numberOfTurn++;
                    }
                    //second player
                    else if(numberOfTurn%2 == 0 && grid[7] == 0){
                        btnSeven.setText("O");
                        btnSeven.setTextColor(getResources().getColor(R.color.red));
                        grid[7] = 2;
                        numberOfTurn++;
                    }
                }
                setScore();
                autoReset();
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if player has already won
                if(checkWin() == 0){

                    //first player
                    if (numberOfTurn % 2 == 1 && grid[8] == 0) {
                        btnEight.setText("X");
                        btnEight.setTextColor(getResources().getColor(R.color.colorPrimary));
                        grid[8] = 1;
                        numberOfTurn++;
                    }
                    //second player
                    else if(numberOfTurn%2 == 0 && grid[8] == 0){
                        btnEight.setText("O");
                        btnEight.setTextColor(getResources().getColor(R.color.red));
                        grid[8] = 2;
                        numberOfTurn++;
                    }
                }
                setScore();
                autoReset();
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
           }
        });


        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PlayerGame.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }

    //036
    //147
    //258

    public void resetGame(){
        //reset grid
        for(int i = 0; i <grid.length; i++)
            grid[i] = 0;

        //reset text
        btnZero.setText("");
        btnOne.setText("");
        btnTwo.setText("");
        btnThree.setText("");
        btnFour.setText("");
        btnFive.setText("");
        btnSix.setText("");
        btnSeven.setText("");
        btnEight.setText("");

        //reset color of buttons
        btnZero.setTextColor(0x00000000);
        btnOne.setTextColor(0x00000000);
        btnTwo.setTextColor(0x00000000);
        btnThree.setTextColor(0x00000000);
        btnFour.setTextColor(0x00000000);
        btnFive.setTextColor(0x00000000);
        btnSix.setTextColor(0x00000000);
        btnSeven.setTextColor(0x00000000);
        btnEight.setTextColor(0x00000000);

        //reset number of turn
        numberOfTurn = 1;

        //reset toggle win
        toggleWin = 0;

    }

    //check if any players won the game
    public int checkWin(){
        //horizontal win for player 1
        if (grid[0] == 1 && grid[3] == 1 && grid[6] == 1) {
            btnZero.setTextColor(getResources().getColor(R.color.black));
            btnThree.setTextColor(getResources().getColor(R.color.black));
            btnSix.setTextColor(getResources().getColor(R.color.black));
            return 1;
        } else if (grid[1] == 1 && grid[4] == 1 && grid[7] == 1) {
            btnOne.setTextColor(getResources().getColor(R.color.black));
            btnFour.setTextColor(getResources().getColor(R.color.black));
            btnSeven.setTextColor(getResources().getColor(R.color.black));
            return 1;
        } else if (grid[2] == 1 && grid[5] == 1 && grid[8] == 1) {
            btnTwo.setTextColor(getResources().getColor(R.color.black));
            btnFive.setTextColor(getResources().getColor(R.color.black));
            btnEight.setTextColor(getResources().getColor(R.color.black));
            return 1;
        }

        //vertical win for player 1
        if (grid[0] == 1 && grid[1] == 1 && grid[2] == 1) {
            btnZero.setTextColor(getResources().getColor(R.color.black));
            btnOne.setTextColor(getResources().getColor(R.color.black));
            btnTwo.setTextColor(getResources().getColor(R.color.black));
            return 1;
        } else if (grid[3] == 1 && grid[4] == 1 && grid[5] == 1) {
            btnThree.setTextColor(getResources().getColor(R.color.black));
            btnFour.setTextColor(getResources().getColor(R.color.black));
            btnFive.setTextColor(getResources().getColor(R.color.black));
            return 1;
        } else if (grid[6] == 1 && grid[7] == 1 && grid[8] == 1) {
            btnSix.setTextColor(getResources().getColor(R.color.black));
            btnSeven.setTextColor(getResources().getColor(R.color.black));
            btnEight.setTextColor(getResources().getColor(R.color.black));
            return 1;
        }

        //diagonal win for player 1
        if (grid[0] == 1 && grid[4] == 1 && grid[8] == 1) {
            btnZero.setTextColor(getResources().getColor(R.color.black));
            btnFour.setTextColor(getResources().getColor(R.color.black));
            btnEight.setTextColor(getResources().getColor(R.color.black));
            return 1;
        } else if (grid[6] == 1 && grid[4] == 1 && grid[2] == 1) {
            btnSix.setTextColor(getResources().getColor(R.color.black));
            btnFour.setTextColor(getResources().getColor(R.color.black));
            btnTwo.setTextColor(getResources().getColor(R.color.black));
            return 1;
        }

        //check horizontal for player 2
        if (grid[0] == 2 && grid[3] == 2 && grid[6] == 2) {
            btnZero.setTextColor(getResources().getColor(R.color.black));
            btnThree.setTextColor(getResources().getColor(R.color.black));
            btnSix.setTextColor(getResources().getColor(R.color.black));
            return 2;
        } else if (grid[1] == 2 && grid[4] == 2 && grid[7] == 2) {
            btnOne.setTextColor(getResources().getColor(R.color.black));
            btnFour.setTextColor(getResources().getColor(R.color.black));
            btnSeven.setTextColor(getResources().getColor(R.color.black));
            return 2;
        } else if (grid[2] == 2 && grid[5] == 2 && grid[8] == 2) {
            btnTwo.setTextColor(getResources().getColor(R.color.black));
            btnFive.setTextColor(getResources().getColor(R.color.black));
            btnEight.setTextColor(getResources().getColor(R.color.black));
            return 2;
        }

        //vertical win for player 2
        if (grid[0] == 2 && grid[1] == 2 && grid[2] == 2) {
            btnZero.setTextColor(getResources().getColor(R.color.black));
            btnOne.setTextColor(getResources().getColor(R.color.black));
            btnTwo.setTextColor(getResources().getColor(R.color.black));
            return 2;
        } else if (grid[3] == 2 && grid[4] == 2 && grid[5] == 2) {
            btnThree.setTextColor(getResources().getColor(R.color.black));
            btnFour.setTextColor(getResources().getColor(R.color.black));
            btnFive.setTextColor(getResources().getColor(R.color.black));
            return 2;
        } else if (grid[6] == 2 && grid[7] == 2 && grid[8] == 2) {
            btnSix.setTextColor(getResources().getColor(R.color.black));
            btnSeven.setTextColor(getResources().getColor(R.color.black));
            btnEight.setTextColor(getResources().getColor(R.color.black));
            return 2;
        }

        //diagonal win for player 2
        if (grid[0] == 2 && grid[4] == 2 && grid[8] == 2) {
            btnZero.setTextColor(getResources().getColor(R.color.black));
            btnFour.setTextColor(getResources().getColor(R.color.black));
            btnEight.setTextColor(getResources().getColor(R.color.black));
            return 2;
        } else if (grid[6] == 2 && grid[4] == 2 && grid[2] == 2) {
            btnSix.setTextColor(getResources().getColor(R.color.black));
            btnFour.setTextColor(getResources().getColor(R.color.black));
            btnTwo.setTextColor(getResources().getColor(R.color.black));
            return 2;
        }
        return 0;
    }

    //set the scores of players
    public void setScore(){
        if(checkWin() == 1 && toggleWin == 0){

            totalP1Score++;
            Toast.makeText(getApplicationContext(),"Good job player 1, you won this round!",Toast.LENGTH_LONG).show();
            p1Score.setText(String.valueOf(totalP1Score));
            toggleWin = 1;
        }
        else if(checkWin() == 2 && toggleWin == 0){
            totalP2Score++;
            Toast.makeText(getApplicationContext(),"Bravo player 2, you beated player 1!",Toast.LENGTH_LONG).show();
            p2Score.setText(String.valueOf(totalP2Score));
            toggleWin = 1;
        }

    }

    //auto reset if no wins
    public void autoReset(){
        if(numberOfTurn == 10 && checkWin() == 0){
            resetGame();
            Toast.makeText(getApplicationContext(), "No players has won the game, board has been reseted.", Toast.LENGTH_SHORT).show();
        }

    }



}
