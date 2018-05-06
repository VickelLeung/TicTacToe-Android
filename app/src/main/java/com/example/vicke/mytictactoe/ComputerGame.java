package com.example.vicke.mytictactoe;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ComputerGame extends AppCompatActivity {

    private Button btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEigth, btnRestart, btnMainMenu;
    private int[] grid;
    private int numberOfTurn = 1;
    private int computerCounter, playerCounter = 0;
    private TextView playerWin, computerWin;
    private int toggleWin = 0;
    private int playFirst = -1;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computer_game);

        grid = new int[9];
        btnZero = findViewById(R.id.btnZero);
        btnOne = findViewById(R.id.btnOne);
        btnTwo = findViewById(R.id.btnTwo);
        btnThree = findViewById(R.id.btnThree);
        btnFour = findViewById(R.id.btnFour);
        btnFive = findViewById(R.id.btnFive);
        btnSix = findViewById(R.id.btnSix);
        btnSeven = findViewById(R.id.btnSeven);
        btnEigth = findViewById(R.id.btnEigth);
        btnRestart = findViewById(R.id.btnRestart);
        playerWin = findViewById(R.id.playerCounter);
        btnMainMenu = findViewById(R.id.btnMenuComp);
        computerWin = findViewById(R.id.computerCounter);

        builder = new AlertDialog.Builder(this);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int numberRolled = extras.getInt("numberRolled");
            playFirst = numberRolled;
        }

        //check if computer play first
        if(playFirst % 2 == 1 )
            compPlayFirst();


//        grid
        /*
           0 3 6
           1 4 7
           2 5 8

         hori: [036] [147] [258
         vert: [012] [345] [678]
         diag: [048] [642]

         */
        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                if(playFirst == 0)
                playerPlayFirst(0,btnZero);
//                else if(playFirst == 1)
//                    compPlayFirst();
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                playerPlayFirst(1, btnOne);


            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               playerPlayFirst(2, btnTwo);
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playerPlayFirst(3, btnThree);

            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playerPlayFirst(4, btnFour);
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playerPlayFirst(5, btnFive);
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playerPlayFirst(6, btnSix);
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playerPlayFirst(7, btnSeven);

            }
        });

        btnEigth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playerPlayFirst(8, btnEigth);

            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkWin() == 0 && numberOfTurn != 9)
                resetGame();
            }
        });

        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ComputerGame.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void setScores(){
        if(checkWin() == 1 && toggleWin == 0){
            toggleWin = 1;
            playerCounter++;
//            Toast.makeText(getApplicationContext(),"You won congratulation!",Toast.LENGTH_LONG).show();
            playerWin.setText(String.valueOf(playerCounter));

            genericBuilder("Congratulation! The player ");
        }
        else if(checkWin() == 2 && toggleWin == 0){
            toggleWin = 1;
            computerCounter++;
//            Toast.makeText(getApplicationContext(),"Oh no, the compute won this round.",Toast.LENGTH_LONG).show();
            computerWin.setText(String.valueOf(computerCounter));

            genericBuilder("Oh no! The computer ");

        }
    }

    //run the game
    public void playerPlayFirst(int x, Button btn){

        //if player/computer did not wins then set X and computer take one turn
        // also check if it is available to place
        if(checkWin() == 0 && (grid[x] == 0 ) ){
            btn.setText("X");
            btn.setTextColor(getResources().getColor(R.color.colorPrimary));
            numberOfTurn++;
            grid[x] = 1;
            computerPlace();
        }
        setScores();
        autoReset();

    }

    //choose who start first using remainder as odd/even. 1-> computer, 0-> human
    public int startFirst(){

        //generate random number
        Random rand = new Random();

        //101 is max and 1 is min
        int n = rand.nextInt(101)+1;

        //check if it is even or odd

        if(n % 2 == 0){
            return 0;
        }
        else
            return 1;

    }

        /*
    check if the player/computer has won the game and update the counter
    *return: 0 for false, 1 for player, 2 for computer
    */
//    hori: [036] [147] [258]
//    vert: [012] [345] [678]
//    diag: [048] [642]

    public int checkWin(){
        //horizontal win for player
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
            btnEigth.setTextColor(getResources().getColor(R.color.black));
            return 1;
        }

        //vertical win for player
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
            btnEigth.setTextColor(getResources().getColor(R.color.black));
            return 1;
        }

        //diagonal win for player
        if (grid[0] == 1 && grid[4] == 1 && grid[8] == 1) {
            btnZero.setTextColor(getResources().getColor(R.color.black));
            btnFour.setTextColor(getResources().getColor(R.color.black));
            btnEigth.setTextColor(getResources().getColor(R.color.black));
            return 1;
        } else if (grid[6] == 1 && grid[4] == 1 && grid[2] == 1) {
            btnSix.setTextColor(getResources().getColor(R.color.black));
            btnFour.setTextColor(getResources().getColor(R.color.black));
            btnTwo.setTextColor(getResources().getColor(R.color.black));
            return 1;
        }

        //check horizontal for computer
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
            btnEigth.setTextColor(getResources().getColor(R.color.black));
            return 2;
        }

        //vertical win for computer
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
            btnEigth.setTextColor(getResources().getColor(R.color.black));
            return 2;
        }

        //diagonal win for computer
        if (grid[0] == 2 && grid[4] == 2 && grid[8] == 2) {
            btnZero.setTextColor(getResources().getColor(R.color.black));
            btnFour.setTextColor(getResources().getColor(R.color.black));
            btnEigth.setTextColor(getResources().getColor(R.color.black));
            return 2;
        } else if (grid[6] == 2 && grid[4] == 2 && grid[2] == 2) {
            btnSix.setTextColor(getResources().getColor(R.color.black));
            btnFour.setTextColor(getResources().getColor(R.color.black));
            btnTwo.setTextColor(getResources().getColor(R.color.black));
            return 2;
        }
        return 0;
    }

    //placeForWin
    public void placeForWin(){
        //036
        //147
        //258

        //check if it is possible to win by placing

        //check horizontals
        //first rows
        if(grid[3] == 2 && grid[6] == 2 && grid[0] == 0){
            grid[0] = 2;
            btnZero.setText("O");
            btnZero.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[0] == 2 && grid[6] == 2 && grid[3] == 0){
            grid[3] = 2;
            btnThree.setText("O");
            btnThree.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[0] == 2 && grid[3] == 2 && grid[6] == 0){
            grid[6] = 2;
            btnSix.setText("O");
            btnSix.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //second row 147
        else if(grid[4] == 2 && grid[7] == 2 && grid[1] == 0){
            grid[1] = 2;
            btnOne.setText("O");
            btnOne.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[1] == 2 && grid[7] == 2 && grid[4] == 0){
            grid[4] = 2;
            btnFour.setText("O");
            btnFour.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[1] == 2 && grid[4] == 2 && grid[7] == 0){
            grid[7] = 2;
            btnSeven.setText("O");
            btnSeven.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //third row 258
        else if(grid[5] == 2 && grid[8] == 2 && grid[2] == 0){
            grid[2] = 2;
            btnTwo.setText("O");
            btnTwo.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[2] == 2 && grid[8] == 2 && grid[5] == 0){
            grid[5] = 2;
            btnFive.setText("O");
            btnFive.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[2] == 2 && grid[5] == 2 && grid[8] == 0){
            grid[8] = 2;
            btnEigth.setText("O");
            btnEigth.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //check for vertical
        //firt column 012
        else if(grid[1] == 2 && grid[2] == 2 && grid[0] == 0){
            grid[0] = 2;
            btnZero.setText("O");
            btnZero.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[0] == 2 && grid[2] == 2 && grid[1] == 0){
            grid[1] = 2;
            btnOne.setText("O");
            btnOne.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[0] == 2 && grid[1] == 2 && grid[2] == 0){
            grid[2] = 2;
            btnTwo.setText("O");
            btnTwo.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //second column 345
        else if(grid[4] == 2 && grid[5] == 2 && grid[3] == 0){
            grid[3] = 2;
            btnThree.setText("O");
            btnThree.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[3] == 2 && grid[5] == 2 && grid[4] == 0){
            grid[4] = 2;
            btnFour.setText("O");
            btnFour.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[3] == 2 && grid[4] == 2 && grid[5] == 0){
            grid[5] = 2;
            btnFive.setText("O");
            btnFive.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //third column 678
        else if(grid[7] == 2 && grid[8] == 2 && grid[6] == 0){
            grid[6] = 2;
            btnSix.setText("O");
            btnSix.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[6] == 2 && grid[8] == 2 && grid[7] == 0){
            grid[7] = 2;
            btnSeven.setText("O");
            btnSeven.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[6] == 2 && grid[7] == 2 && grid[8] == 0){
            grid[8] = 2;
            btnEigth.setText("O");
            btnEigth.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //diagonal 048
        else if(grid[4] == 2 && grid[8] == 2 && grid[0] == 0){
            grid[0] = 2;
            btnZero.setText("O");
            btnZero.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[0] == 2 && grid[8] == 2 && grid[4] == 0){
            grid[4] = 2;
            btnFour.setText("O");
            btnFour.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[0] == 2 && grid[4] == 2 && grid[8] == 0){
            grid[8] = 2;
            btnEigth.setText("O");
            btnEigth.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //second diagnoal 642
        else if(grid[4] == 2 && grid[2] == 2 && grid[6] == 0){
            grid[6] = 2;
            btnSix.setText("O");
            btnSix.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[6] == 2 && grid[2] == 2 && grid[4] == 0){
            grid[4] = 2;
            btnFour.setText("O");
            btnFour.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[6] == 2 && grid[4] == 2 && grid[2] == 0){
            grid[2] = 2;
            btnTwo.setText("O");
            btnTwo.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
    }

    public void deflect(){

        //036
        //147
        //258
        //horizontal prevent
        // first row 036
        if(grid[3] == 1 && grid[6] == 1 && grid[0] == 0){
            grid[0] = 2;
            btnZero.setText("O");
            btnZero.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[0] == 1 && grid[6] == 1 && grid[3] == 0 ){
            grid[3] = 2;
            btnThree.setText("O");
            btnThree.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[0] == 1 && grid[3] == 1 && grid[6] == 0){
            grid[6] = 2;
            btnSix.setText("O");
            btnSix.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        // second row 147
        else if(grid[4] == 1 && grid[7] == 1 && grid[1] == 0){
            grid[1] = 2;
            btnOne.setText("O");
            btnOne.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[1] == 1 && grid[7] == 1 && grid[4] == 0){
            grid[4] = 2;
            btnFour.setText("O");
            btnFour.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[1] == 1 && grid[4] == 1 && grid[7] == 0){
            grid[7] = 2;
            btnSeven.setText("O");
            btnSeven.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //third row 258
        else if(grid[5] == 1 && grid[8] == 1 && grid[2] == 0){
            grid[2] = 2;
            btnTwo.setText("O");
            btnTwo.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[2] == 1 && grid[8] == 1 && grid[5] == 0){
            grid[5] = 2;
            btnFive.setText("O");
            btnFive.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[2] == 1 && grid[5] == 1 && grid[8] == 0) {
            grid[8] =2;
            btnEigth.setText("O");
            btnEigth.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //vertical prevent
        //first column  012
        else if(grid[1] == 1 && grid[2] == 1 && grid[0] == 0){
            grid[0] = 2;
            btnZero.setText("O");
            btnZero.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[0] == 1 && grid[2] == 1 && grid[1] == 0){
            grid[1] = 2;
            btnOne.setText("O");
            btnOne.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[0] == 1 && grid[1] == 1 && grid[2] == 0){
            grid[2] = 2;
            btnTwo.setText("O");
            btnTwo.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //second column 345
        else if(grid[4] == 1 && grid[5] == 1 && grid[3] == 0){
            grid[3] = 2;
            btnThree.setText("O");
            btnThree.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[3] == 1 && grid[5] == 1 && grid[4] == 0){
            grid[4] = 2;
            btnFour.setText('O');
            btnFour.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[3] == 1 && grid[4] == 1 && grid[5] == 0){
            grid[5] = 2;
            btnFive.setText("O");
            btnFive.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //third column 678
        else if(grid[7] == 1 && grid[8] == 1 && grid[6] == 0){
            grid[6] = 2;
            btnSix.setText("O");
            btnSix.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[6] == 1 && grid[8] == 1 && grid[7] == 0){
            grid[7] = 2;
            btnSeven.setText("O");
            btnSeven.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[6] == 1 && grid[7] == 1 && grid[8] == 0){
            grid[8] = 2;
            btnEigth.setText("O");
            btnEigth.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }

        //diagonal 048
        else if(grid[4] == 1 && grid[8] == 1 && grid[0] == 0){
            grid[0] = 2;
            btnZero.setText("O");
            btnZero.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[0] == 1 && grid[8] == 1 && grid[4] == 0){
            grid[4] = 2;
            btnFour.setText("O");
            btnFour.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[0] == 1 && grid[4] == 1 && grid[8] == 0){
            grid[8] = 2;
            btnEigth.setText("O");
            btnEigth.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //diagonal  642
        else if(grid[4] == 1 && grid[2] == 1 && grid[6] == 0){
            grid[6] = 2;
            btnSix.setText("O");
            btnSix.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[6] == 1 && grid[2] == 1 && grid[4] == 0){
            grid[4] = 2;
            btnFour.setText("O");
            btnFour.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[6] == 1 && grid[4] == 1 && grid[2] == 0){
            grid[2] = 2;
            btnTwo.setText("O");
            btnTwo.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }

    }

    // if player doesn't place in middle
    public void strategy(){

        //036
        //147
        //258
        //strategy placing middle then top/bot/left/right middle
        if (grid[4] == 0) {
            grid[4] = 2;
            btnFour.setText("O");
            btnFour.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }

        //top
        else if (grid[3] == 0) {
            grid[3] = 2;
            btnThree.setText("O");
            btnThree.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //bottom
        else if (grid[5] == 0) {
            grid[5] = 2;
            btnFive.setText("O");
            btnFive.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //left
        else if (grid[1] == 0) {
            grid[1] = 2;
            btnOne.setText("O");
            btnOne.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //right
        else if (grid[7] == 0) {
            grid[7] = 2;
            btnSeven.setText("O");
            btnSeven.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //corners
        //top-left
        else if(grid[0] == 0 ){
            grid[0] = 2;
            btnZero.setText("O");
            btnZero.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //top right
        else if(grid[6] == 0){
            grid[6] = 2;
            btnSix.setText("O");
            btnSix.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //bot left
        else if(grid[2] == 0){
            grid[2] = 2;
            btnTwo.setText("O");
            btnTwo.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //bot right
        else if(grid[8] == 0){
            grid[8] = 2;
            btnEigth.setText("O");
            btnEigth.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }

    }

    //if player placed in middle
    public void strategyMiddle(){

        //place in corners
        //corners
        //top-left
        if(grid[0] == 0 ){
            grid[0] = 2;
            btnZero.setText("O");
            btnZero.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //top right
        else if(grid[6] == 0){
            grid[6] = 2;
            btnSix.setText("O");
            btnSix.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //bot left
        else if(grid[2] == 0){
            grid[2] = 2;
            btnTwo.setText("O");
            btnTwo.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        //bot right
        else if(grid[8] == 0){
            grid[8] = 2;
            btnEigth.setText("O");
            btnEigth.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }

    }

    public void cornerDeath(){
        //036
        //147
        //258

        if(grid[1] == 1 && grid[3] == 1 && grid[0] == 0){
            grid[0] = 2;
            btnZero.setText("O");
            btnZero.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[1] == 1 && grid[5] == 1 && grid[2] == 0){
            grid[2] = 2;
            btnTwo.setText("O");
            btnTwo.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[3] == 1 && grid[7] == 1 && grid[6] == 0){
            grid[6] = 2;
            btnSix.setText("O");
            btnSix.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }
        else if(grid[7] == 1 && grid[5] == 1 && grid[8] == 0){
            grid[8] = 2;
            btnEigth.setText("O");
            btnEigth.setTextColor(getResources().getColor(R.color.red));
            numberOfTurn++;
        }

    }

    //will place an O's and try to deflect the player from winning
    public void computerPlace(){

        //computer try to win
        placeForWin();

        //computer deflect 80% of time


        //computer try to deflect player
        if(numberOfTurn %2 == 0) {
            deflect();


            if(numberOfTurn % 2 == 0 && (grid[1] == 1 || grid[3] == 1 || grid[5] == 1 || grid[7] == 1) )
                cornerDeath();

            if(numberOfTurn %2 == 0 && grid[4] == 1){
                strategyMiddle();
            }


            //computer use basic strategy
            if(numberOfTurn % 2 == 0) {
               strategy();
            }
        }
    }

    //if computer start first, randomly place in the array
    public void compPlayFirst(){

        //get random numbers
        Random rand = new Random();

        int r = rand.nextInt(8);

        //place the computer turn on grid
        if(r == 0)
            setGrid(0, btnZero);
        if(r == 1)
            setGrid(1, btnOne);
        if(r == 2)
            setGrid(2, btnTwo);
        if(r == 3)
            setGrid(3, btnThree);
        if(r == 4)
            setGrid(4, btnFour);
        if(r == 5)
            setGrid(5, btnFive);
        if(r == 6)
            setGrid(6, btnSix);
        if(r == 7)
            setGrid(7, btnSeven);
        if(r == 8)
            setGrid(8, btnEigth);

    }

    public void setGrid(int x, Button btn){

            grid[x] = 2;
            btn.setText("O");
            btn.setTextColor(getResources().getColor(R.color.red));
    }

    //reset the game attribute to start a new game
    public void resetGame(){

            //reset all text to to empty
            btnZero.setText("");
            btnOne.setText("");
            btnTwo.setText("");
            btnThree.setText("");
            btnFour.setText("");
            btnFive.setText("");
            btnSix.setText("");
            btnSeven.setText("");
            btnEigth.setText("");

            //reset all grid to 0's
            for (int i = 0; i < grid.length; i++)
                grid[i] = 0;

            //reset the number of turn
            numberOfTurn = 1;

            //reset scores
            toggleWin = 0;

            //check if computer play first
            if (playFirst % 2 == 1)
                compPlayFirst();

    }

    public void autoReset(){

        builder = new AlertDialog.Builder(this);

        if(playFirst%2 == 1){

            if(numberOfTurn == 9 && checkWin() == 0){
//                Toast.makeText(getApplicationContext(), "No players has won the game, board has been reseted.", Toast.LENGTH_SHORT).show();

                genericBuilder("No player ");
            }
        }
        else if(playFirst%2 == 0){
            if(numberOfTurn == 10 && checkWin() == 0){
//                Toast.makeText(getApplicationContext(), "No players has won the game, board has been reseted.", Toast.LENGTH_SHORT).show();

                genericBuilder("No player ");
            }
        }
    }

    public void genericBuilder(String s){
        builder.setCancelable(false);
        builder.setTitle( s + "has won the game");
        builder.setMessage("Would you like to play again?");

        builder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent mainMenu = new Intent(ComputerGame.this, MainActivity.class);
                        startActivity(mainMenu);

                    }
                });
        builder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        playFirst++;
                        resetGame();
                    }
                });

        final AlertDialog dialog = builder.create();
        builder.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
}